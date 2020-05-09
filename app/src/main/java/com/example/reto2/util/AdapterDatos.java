package com.example.reto2.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.example.reto2.RecyclerViewClickInterface;
import com.example.reto2.model.Data;

import java.util.ArrayList;

public class AdapterDatos
        extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Data> listDatos;
    private View.OnClickListener listener;
    private RecyclerViewClickInterface recyclerViewClickInterface;
    private String idPlayList;


    public AdapterDatos(ArrayList<Data> listDatos, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.listDatos = listDatos;
        this.recyclerViewClickInterface = recyclerViewClickInterface;

    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);



        return new ViewHolderDatos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.title_playlist.setText(listDatos.get(position).getTitle());
        holder.author_playlist.setText(listDatos.get(position).getUser().getName());
        holder.nbtracks_playlist.setText(listDatos.get(position).getNb_tracks());
        Glide.with(holder.img_playlist).load(listDatos.get(position)
                .getPicture()).centerCrop().into(holder.img_playlist);

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }






    public void get(int position) {
    }



    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView title_playlist;
        TextView author_playlist;
        TextView nbtracks_playlist;
        ImageView img_playlist;
        RecyclerView  playlist_rv;







        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            title_playlist = itemView.findViewById(R.id.name_track2);
            author_playlist = itemView.findViewById(R.id.name_artist);
            nbtracks_playlist = itemView.findViewById(R.id.release_year);
            img_playlist = itemView.findViewById(R.id.img_track);
            playlist_rv = itemView.findViewById(R.id.playlist_rv);

            itemView.setOnClickListener(view -> {
                recyclerViewClickInterface.onItemClick(getAdapterPosition());

            });

            itemView.setOnLongClickListener((view)->{

                        recyclerViewClickInterface.onLongItemClick(getAdapterPosition());
                        return  true;


                    });







        }



       /* public void asignarDatos(Data datos) {
            title_playlist.setText(datos.getTitle());
            author_playlist.setText(datos.getUser().getName());
            nbtracks_playlist.setText(datos.getNb_tracks());
        }*/
    }

    public String getIdPlayList() {
        return idPlayList;
    }
}
