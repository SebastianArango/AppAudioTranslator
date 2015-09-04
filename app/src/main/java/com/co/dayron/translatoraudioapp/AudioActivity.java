package com.co.dayron.translatoraudioapp;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

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

    //objeto para grabar el audio
    MediaRecorder recorder;
    //objeto para reproducir el audio
    MediaPlayer player;
    //objeto de referencia al archivo creado
    File fileAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        ButterKnife.bind(this);


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

            fileAudio = File.createTempFile("temporal", ".3gp", path);
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
}
