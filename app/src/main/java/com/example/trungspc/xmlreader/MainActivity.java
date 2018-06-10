package com.example.trungspc.xmlreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trungspc.xmlreader.parser.IService;
import com.example.trungspc.xmlreader.parser.RetrofitInstance;
import com.example.trungspc.xmlreader.parser.Song;
import com.example.trungspc.xmlreader.parser.XMLResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ListView lvSongs;
    CustomAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSongs = findViewById(R.id.lv_songs);

        IService service = RetrofitInstance.getRetrofitXML().create(IService.class);
        service.getSongs().enqueue(new Callback<XMLResponse>() {
            @Override
            public void onResponse(Call<XMLResponse> call, Response<XMLResponse> response) {
                ArrayList<Song> songList = response.body().songList;
                songAdapter = new CustomAdapter(MainActivity.this, 0, songList);
                lvSongs.setAdapter(songAdapter);
            }

            @Override
            public void onFailure(Call<XMLResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Failure! See log", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
