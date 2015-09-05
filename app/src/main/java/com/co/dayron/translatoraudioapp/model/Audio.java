package com.co.dayron.translatoraudioapp.model;

import com.co.dayron.translatoraudioapp.Callback;
import com.co.dayron.translatoraudioapp.repositories.RepositorioAudio;

import java.io.File;

/**
 * Created by dayron on 9/4/15.
 */
public class Audio {

    File audioFile;

    public File getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(File audioFile) {
        this.audioFile = audioFile;
    }


    public void getAudioFile(File audioFile, final Callback<File> callback) {
        RepositorioAudio.getInstance().getFileAudio(audioFile, new Callback<File>() {
                    @Override
                    public void complete(File data) {
                        callback.complete(data);
                    }

                    @Override
                    public void failure(Error error) {
                    callback.failure(error);
                    }
                }

        );

    }
}
