package com.co.dayron.translatoraudioapp.repositories;

import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;

import com.co.dayron.translatoraudioapp.Callback;
import com.co.dayron.translatoraudioapp.model.*;
import com.co.dayron.translatoraudioapp.model.Error;

import java.io.File;
//
//import retrofit.RetrofitError;
//import retrofit.client.Response;

/**
 * Created by dayron on 9/4/15.
 */
public class RepositorioAudio implements IRepositoryAudio {

    private static IRepositoryAudio instance = new RepositorioAudio();

    public static IRepositoryAudio getInstance(){

        return instance;
    }


//    @Override
//    public void getFileAudio(File audioFile, final Callback<File> callback) {
//
////        IRestClient client = ApiClient.getInstance().getClient();
////        client.getAudioFile(audioFile, new retrofit.Callback<File>() {
////            @Override
////            public void success(File file, Response response) {
////                callback.complete(file);
////            }
////
////            @Override
////            public void failure(RetrofitError error) {
////                callback.failure((Error) error.getBodyAs(com.co.dayron.translatoraudioapp.model.Error.class));
////            }
////        });
//    }
}
