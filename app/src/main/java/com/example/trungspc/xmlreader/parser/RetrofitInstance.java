package com.example.trungspc.xmlreader.parser;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofitXML;

    public static Retrofit getRetrofitXML() {
        if (retrofitXML == null) {
            retrofitXML = new Retrofit.Builder()
                    .baseUrl("https://api.androidhive.info")
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();

        }
        return retrofitXML;
    }
}
