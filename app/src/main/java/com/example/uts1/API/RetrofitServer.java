package com.example.uts1.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {
    private static final String baseURL = "https://halosehat2.000webhostapp.com/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if(retro == null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }

}
