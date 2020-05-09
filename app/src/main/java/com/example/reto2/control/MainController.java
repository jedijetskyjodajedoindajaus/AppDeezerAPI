package com.example.reto2.control;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.reto2.model.Data;
import com.example.reto2.model.Deezer;
import com.example.reto2.views.MainActivity;
import com.example.reto2.R;
import com.example.reto2.util.Constants;
import com.example.reto2.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private MainActivity activity;
    private HTTPSWebUtilDomi utilJedi;
    private ArrayList<Data> listDatos;


    public MainController(MainActivity activity) {
        this.activity = activity;
        this.activity.getSearch_btn().setOnClickListener(this);
        utilJedi = new HTTPSWebUtilDomi();
        utilJedi.setListener(this);

        listDatos = new ArrayList<Data>();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_btn:
                String playlistName = activity.getSearch_edt().getText().toString();

                Log.e("hellow", playlistName);

                new Thread(
                        () -> {
                            utilJedi.GETrequest(Constants.SEARCH_CALLBACK,
                                    "https://api.deezer.com/search/playlist?q=" + playlistName);


                            if (listDatos.size() < 23) {
                                for (int i = 0; i < 25; i++) {
                                    Deezer deezer = new Deezer();

                                }
                            }
                        }

                ).start();

                break;

        }


    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                Deezer deezer = gson.fromJson(response, Deezer.class);
                Log.e(">>>",response);

                activity.runOnUiThread(

                        ()->{
                            for(int i = 0; i<25;i++){
                                listDatos.add(deezer.getData()[i]);
                                Log.e(">>>", String.valueOf(listDatos.size()));
                            }
                        }
                );

                break;



        }

    }

    public ArrayList<Data> getListDatos() {
        return listDatos;
    }


}


