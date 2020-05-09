package com.example.reto2.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.example.reto2.RecyclerViewClickInterface;
import com.example.reto2.control.MainController;
import com.example.reto2.model.Data;
import com.example.reto2.model.Deezer;
import com.example.reto2.model.Track;
import com.example.reto2.util.AdapterDatos;
import com.example.reto2.util.Constants;
import com.example.reto2.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface, HTTPSWebUtilDomi.OnResponseListener{
    private EditText search_edt;
    private Button search_btn;
    private RecyclerView playlist_rv;
    private ImageView image_btn;
    private MainController controller;
    private AdapterDatos adapter;
    private ArrayList<Data> listDat;
    private HTTPSWebUtilDomi utilJedi;
    private String idPlayList;
    private  String name;

    public EditText getSearch_edt() {
        return search_edt;
    }


    public Button getSearch_btn() {
        return search_btn;
    }


    public RecyclerView getPlaylist_rv() {
        return playlist_rv;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_edt = findViewById(R.id.search_edt);
        search_btn = findViewById(R.id.search_btn);
        playlist_rv = findViewById(R.id.playlist_rv);
        image_btn = findViewById(R.id.image_btn);
        controller = new MainController(this);

        playlist_rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterDatos(controller.getListDatos(), this);
        listDat = new ArrayList<>();

        playlist_rv.setAdapter(adapter);

        utilJedi = new HTTPSWebUtilDomi();
        utilJedi.setListener(this);


    }


    public MainController getController(){
        return controller;
    }

    public String getIdPlayList() {
        return idPlayList;
    }

    @Override
    public void onItemClick(int position) {

        name = controller.getListDatos().get(position).getUser().getName();

                    new Thread(
                            () -> {
                                idPlayList = controller.getListDatos().get(position).getId();
                                Log.e(">>>>>>>>>>>>>","hey heyeyheye"+idPlayList);

                                utilJedi.GETrequest(Constants.SEARCH_PLAYLIST,
                                        "https://api.deezer.com/playlist/"+idPlayList);

                                Log.e(">>>>>>>>>>>>>>>>>>>>>","Entrooooo aquiii "+idPlayList);

                            }
                    ).start();

    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID) {
            case Constants.SEARCH_PLAYLIST:
                Gson gson = new Gson();
                Data data = gson.fromJson(response, Data.class);
                Log.e("AAAAAAAAAAA",response);

                ArrayList<Track> tracks = new ArrayList<>();

                String canciones ="" + data.getTracks().getData().length;
                Log.e("hellow madafaka", canciones);

                for(int i = 0; i<data.getTracks().getData().length; i++){
                    tracks.add(data.getTracks().getData()[i]);
                }


                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("nameT", data.getTitle());
                intent.putExtra("nameN", data.getNb_tracks());
                intent.putExtra("nameH", data.getPicture_big());
                intent.putExtra("nameU", name);

                intent.putExtra("tracks", tracks);

                startActivity(intent);


        }

    }

    @Override
    public void onLongItemClick(int position) {

    }



}

