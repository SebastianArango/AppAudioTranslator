package com.co.dayron.translatoraudioapp.repositories;

import com.co.dayron.translatoraudioapp.Callback;

import java.io.File;

import retrofit.http.GET;

/**
 * Created by dayron on 9/4/15.
 */
public interface IRepositoryAudio {
    @GET("/translate/spanish_to_english")
    public void getFileAudio(File audioFile, Callback<File> callback);
}
