package com.co.dayron.translatoraudioapp.repositories;



import java.io.File;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.Callback;

/**
 * Created by dayron on 9/4/15.
 */
public interface IRestClient {
    @GET("/users/{user}/repos")
    public void getAudioFile(@Path("audio") File audio, Callback<File> callback);
}
