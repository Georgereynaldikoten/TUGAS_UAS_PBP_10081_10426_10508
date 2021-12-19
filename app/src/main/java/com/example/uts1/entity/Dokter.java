package com.example.uts1.entity;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class Dokter
{
    public String nama, spesialis, no_str, tempat_praktik;
    public String imgURL, jadwal;

    public Dokter(String nama, String spesialis, String no_str, String tempat_praktik, String imgURL, String jadwal)
    {
        this.nama = nama;
        this.spesialis = spesialis;
        this.no_str = no_str;
        this.tempat_praktik = tempat_praktik;
        this.imgURL = imgURL;
        this.jadwal = jadwal;
    }

    public String getNama()
    {
        return nama;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public String getSpesialis()
    {
        return spesialis;
    }

    public void setSpesialis(String spesialis)
    {
        this.spesialis = spesialis;
    }

    public String getNo_str()
    {
        return no_str;
    }

    public void setNo_str(String no_str)
    {
        this.no_str= no_str;
    }

    public String getTempat_praktik()
    {
        return tempat_praktik;
    }

    public void setTempat_praktik(String tempat_praktik)
    {
        this.tempat_praktik = tempat_praktik;
    }

    public String getImgURL()
    {
        return imgURL;
    }

    public void setImgURL(String imgURL)
    {
        this.imgURL = imgURL;
    }

    public String getJadwal()
    {
        return jadwal;
    }

    public void setJadwal(String jadwal)
    {
        this.jadwal = jadwal;
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String imageUrl)
    {
        Picasso.with(view.getContext().getApplicationContext())
                .load(imageUrl)
                .fit()
                .into(view);
    }
}
