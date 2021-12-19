package com.example.uts1.Model;

import java.util.List;

public class ResponseModel {
    private int kode;
    private String pesan;
    private List<ReminderModel> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<ReminderModel> getData() {
        return data;
    }

    public void setData(List<ReminderModel> data) {
        this.data = data;
    }


}
