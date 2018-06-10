package com.example.trungspc.xmlreader.parser;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {
    @GET("/music/music.xml")
    Call<XMLResponse> getSongs();
}
