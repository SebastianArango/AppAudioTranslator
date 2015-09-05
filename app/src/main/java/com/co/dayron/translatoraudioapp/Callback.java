package com.co.dayron.translatoraudioapp;

import com.co.dayron.translatoraudioapp.model.*;

/**
 * Created by dayron on 9/4/15.
 */
public interface Callback<T> {

    /** Successful . */
    void complete(T data);



    /**
     * Unsuccessful.
     */
    void failure(com.co.dayron.translatoraudioapp.model.Error error);
}