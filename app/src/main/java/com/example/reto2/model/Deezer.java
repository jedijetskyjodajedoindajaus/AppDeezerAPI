package com.example.reto2.model;

public class Deezer {

    private Data[] data;



    public Deezer(Data[] datas) {
        this.data = datas;

    }

    public Deezer() {
    }


    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }


}
