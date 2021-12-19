package com.example.uts1.entity;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class Artikel {
    public String gambar;
    public String tag;
    public String judul;
    public String isi, dekripsi;

    public Artikel(String gambar, String tag, String judul, String isi, String deskripsi)
    {
        this.gambar = gambar;
        this.tag = tag;
        this.judul = judul;
        this.isi = isi;
        this.dekripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) { this.tag = tag; }

    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }
    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getDekripsi() {
        return dekripsi;
    }
    public void setDekripsi(String dekripsi) {
        this.dekripsi = dekripsi;
    }


    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imageUrl)
    {
        Glide.with(imageView)
                .load(imageUrl)
                .into(imageView);
    }
}