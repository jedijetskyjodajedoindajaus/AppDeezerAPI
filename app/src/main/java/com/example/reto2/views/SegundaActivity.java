package com.example.reto2.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.example.reto2.RecyclerViewClickInterface;
import com.example.reto2.model.Data;
import com.example.reto2.model.Deezer;
import com.example.reto2.model.Track;
import com.example.reto2.model.TrackContainer;
import com.example.reto2.util.AdapterDatos;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity implements RecyclerViewClickInterface {

    private ImageView img_header;
    private TextView name_playlist;
    private TextView description_playlist;
    private TextView numberTracks;
    private ListView tracks_lv;
    private AdapterTracks adapterTracks;
    private ArrayList<Track> list;

    public ImageView getImg_header() {
        return img_header;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        img_header = findViewById(R.id.img_header);
        name_playlist = findViewById(R.id.name_playlist);
        description_playlist = findViewById(R.id.description_playlist);
        numberTracks = findViewById(R.id.numberTracks);
        tracks_lv = findViewById(R.id.tracks_lv);
        list = new ArrayList<>();


        Intent intent =  getIntent();
        String nameP = intent.getStringExtra("nameT");
        String nameU = intent.getStringExtra("nameU");
        String nameN = intent.getStringExtra("nameN");
        String imgH = intent.getStringExtra("nameH");
        list = (ArrayList<Track>) intent.getExtras().getSerializable("tracks");

        name_playlist.setText(nameP);
        description_playlist.setText(nameU);
        numberTracks.setText(nameN + " canciones en esta playlist");

        Glide.with(img_header).load(imgH).centerCrop().into(img_header);

        adapterTracks = new AdapterTracks(list,this,this);
        tracks_lv.setAdapter(adapterTracks);

    }


    @Override
    public void onItemClick(int position) {


        Intent intent = new Intent(getApplicationContext(), TerceraActivity.class);
        intent.putExtra("nameT", list.get(position).getTitle());
        intent.putExtra("nameArtist", list.get(position).getArtist().getName());
        intent.putExtra("nameAlbum", list.get(position).getAlbum().getTitle());
        intent.putExtra("duration",list.get(position).getDuration());
        intent.putExtra("urlImg", list.get(position).getAlbum().getCover_medium());
        intent.putExtra("preview", list.get(position).getPreview());
        startActivity(intent);

    }

    @Override
    public void onLongItemClick(int position) {

    }

}
