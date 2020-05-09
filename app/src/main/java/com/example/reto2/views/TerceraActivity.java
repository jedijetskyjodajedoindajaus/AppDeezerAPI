package com.example.reto2.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;

public class TerceraActivity extends AppCompatActivity {

    private Button listen_trackBTN;
    private TextView name_track;
    private TextView artist_track;
    private TextView album_track;
    private TextView duration_track;
    private ImageView imgTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        listen_trackBTN = findViewById(R.id.listen_trackBTN);
        name_track = findViewById(R.id.name_track2);
        artist_track = findViewById(R.id.artist_track);
        album_track = findViewById(R.id.album_track);
        duration_track = findViewById(R.id.duration_track);
        imgTrack = findViewById(R.id.imgTrack);


        Intent intent =  getIntent();
        String nameTrack = intent.getStringExtra("nameT");
        String nameArtist= intent.getStringExtra("nameArtist");
        String nameAlbum = intent.getStringExtra("nameAlbum");
        String duration = intent.getStringExtra("duration");
        String urlImg = intent.getStringExtra("urlImg");
        String preview = intent.getStringExtra("preview");

        name_track.setText(nameTrack);
        artist_track.setText(nameArtist);
        album_track.setText(nameAlbum);
        duration_track.setText(duration + "segundos");


        Glide.with(imgTrack).load(urlImg).centerCrop().into(imgTrack);

        listen_trackBTN.setOnClickListener(v -> {
            Uri uri = Uri.parse(preview);
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);


        });


    }




}
