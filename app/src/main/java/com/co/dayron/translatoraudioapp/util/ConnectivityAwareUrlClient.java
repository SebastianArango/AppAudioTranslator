package com.co.dayron.translatoraudioapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.co.dayron.translatoraudioapp.model.Application;

import java.io.IOException;

//import retrofit.client.Client;
//import retrofit.client.Request;
//import retrofit.client.Response;

/**
 * Created by dayron on 9/4/15.
 */
public class ConnectivityAwareUrlClient {

//
//    Client wrappedClient;
//    private ConnectivityManager ncm;
//
//    public ConnectivityAwareUrlClient(Client okHttpClient, ConnectivityManager cm) {
//        this.wrappedClient = okHttpClient;
//        this.ncm = cm;
//    }
//
//    @Override
//    public Response execute(Request request) throws IOException {
//        ConnectivityManager connMgr = (ConnectivityManager) Application.getInstance().getApplicationContext().
//                getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//
//
//
//        if (networkInfo != null) {
//            if (!networkInfo.isConnected()) {
//                Log.d("No connectivity %s ", request.toString());
//                try {
//                    throw new NoConnectivityException("No connectivity");
//                } catch (NoConnectivityException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }else{
//            try {
//                throw new NoConnectivityException("No connectivity");
//            } catch (NoConnectivityException e) {
//                e.printStackTrace();
//            }
//        }
//        return wrappedClient.execute(request);
//
//    }


}