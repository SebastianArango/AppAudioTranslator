package com.co.dayron.translatoraudioapp.activity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.co.dayron.translatoraudioapp.R;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AudioActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {


    @Bind(R.id.txtstatus)
    TextView txtstatus;

    @Bind(R.id.btnrecord)
    Button btnrecord;

    @Bind(R.id.btnstop)
    Button btnstop;

    @Bind(R.id.btnreproduce)
    Button btnreproduce;

    @Bind(R.id.btnsend)
    Button btnsend;

    //objeto para grabar el audio
    MediaRecorder recorder;
    //objeto para reproducir el audio
    MediaPlayer player;
    //objeto de referencia al archivo creado
    File fileAudio;

    String route;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        ButterKnife.bind(this);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }

    @OnClick(R.id.btnrecord)
    public void recordAudio(View view) {

        recorder = new MediaRecorder();
        //enciendo el microfono como entrada
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //especifico el formato de audio
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory().getPath());

        try {

            fileAudio = File.createTempFile("audio1", ".3gp", path);
            route = fileAudio.toString();
        } catch (IOException e) {
        }
        recorder.setOutputFile(fileAudio.getAbsolutePath());
        try {
            recorder.prepare();
        } catch (IOException e) {
        }
        recorder.start();
        txtstatus.setText("Grabando");
        btnrecord.setEnabled(false);
        btnreproduce.setEnabled(false);
        btnstop.setEnabled(true);

    }

    @OnClick(R.id.btnstop)
    public void stopAudio(View view) {


        if (fileAudio!=null){
            recorder.stop();
            recorder.release();
            player = new MediaPlayer();
            player.setOnCompletionListener(this);
            try {
                player.setDataSource(fileAudio.getAbsolutePath());
            } catch (IOException e) {
            }
            try {
                player.prepare();
            } catch (IOException e) {
            }
            btnrecord.setEnabled(true);
            btnstop.setEnabled(false);
            btnreproduce.setEnabled(true);
            txtstatus.setText("Listo para reproducir");

        }else{
            btnreproduce.setEnabled(false);
            Toast.makeText(this, "No hay nada grabado", Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.btnreproduce)
    public void reproduceAudio(View view) {
        player.start();
        btnrecord.setEnabled(false);
        btnstop.setEnabled(false);
        btnreproduce.setEnabled(false);
        txtstatus.setText("Reproduciendo");

    }



    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        btnrecord.setEnabled(true);
        btnstop.setEnabled(true);
        btnreproduce.setEnabled(true);
        txtstatus.setText("Listo");

    }

    @OnClick(R.id.btnsend)
    public void sendFileAudio(View view) {


        SpeechToText service = new SpeechToText();
        service.setUsernameAndPassword("02b03789-07c1-4d2a-8b70-3d00e0536032", "z2ypCGYef2pT");

        File audio = new File(Environment.getExternalStorageDirectory().getPath()+"/Download/sample1.wav");
        //File audio = new File(route);
        SpeechResults transcript = service.recognize(audio, "audio/3gp; rate=44100");
        System.out.println(transcript);


//
//        TextToSpeech textservice = new TextToSpeech();
//        textservice.setUsernameAndPassword("02b03789-07c1-4d2a-8b70-3d00e0536032", "z2ypCGYef2pT");
//
//        textservice.synthesize(transcript.toString(), );
//        List<Voice> voices = textservice.getVoices();
//        System.out.println(voices);


//        Audio audio = new Audio();
//            audio.getAudioFile(fileAudio, new Callback<File>() {
//                @Override
//                public void complete(File data) {
//                    File mTraslator = data;
//                }
//
//                @Override
//                public void failure(com.co.dayron.translatoraudioapp.model.Error error) {
//                    Toast.makeText(getApplicationContext(), "No se logro traducir" + error.getMessaje().toString(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }


    }


}
