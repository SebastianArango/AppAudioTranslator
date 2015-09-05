package com.co.dayron.translatoraudioapp.repositories;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.co.dayron.translatoraudioapp.model.Application;
import com.co.dayron.translatoraudioapp.util.ConnectivityAwareUrlClient;

//import retrofit.RestAdapter;
//import retrofit.client.OkClient;
/**
 * Created by dayron on 9/4/15.
 */
public class ApiClient {

//    private static final String API_BASE_PATH = "https://stream.watsonplatform.net/speech-to-text/api";
//    private static ApiClient INSTANCE = new ApiClient();
//
//
//
//    public static ApiClient getInstance() {
//        return INSTANCE;
//    }
//
//    private IRestClient apiClient;
//
//    public IRestClient getClient() {
//        return apiClient;
//    }
//
//    private Context context;
//
//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//
//    private ApiClient() {
//
////        RequestInterceptor requestInterceptor = new RequestInterceptor() {
////            @Override
////            public void intercept(RequestFacade request) {
////
////
////                if (token != null && !token.isEmpty())
////                    request.addHeader("token", token);
////            }
////        };
//        //TODO still need set custom error
//
//        ConnectivityManager cm =
//                (ConnectivityManager) Application.getInstance().getApplicationContext()
//                        .getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(API_BASE_PATH)
//                .setClient(new ConnectivityAwareUrlClient(new OkClient(), cm))
//                //.setRequestInterceptor(requestInterceptor)
//                .build();
//
//        apiClient = restAdapter.create(IRestClient.class);
//    }
//
//    public boolean isOnline() {
//        Context context = Application.getInstance().getApplicationContext();
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        return netInfo != null && netInfo.isConnected();
//    }

}