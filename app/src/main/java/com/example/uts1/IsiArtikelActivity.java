package com.example.uts1;

import static com.example.uts1.entity.Dokter.loadImage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class IsiArtikelActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_artikel);
        TextView tag = findViewById(R.id.Tag);
        TextView judul = findViewById(R.id.judul);
        TextView isi = findViewById(R.id.isi);
        ImageView gambar = findViewById(R.id.gambar);
        ImageView arrow_back = findViewById(R.id.arrow_back);

        Intent i = getIntent();
        String tagArtikel = i.getStringExtra("tag");
        String judulArtikel = i.getStringExtra("judul");
        String gambarArtikel = i.getStringExtra("img");
        String isiArtikel = i.getStringExtra("isi");

        tag.setText(tagArtikel);
        judul.setText(judulArtikel);
        isi.setText(isiArtikel);
        loadImage(gambar, gambarArtikel);

        arrow_back.setOnClickListener(view -> {
            Intent moveMain = new Intent(IsiArtikelActivity.this, ArtikelActivity.class);
            startActivity(moveMain);
        });
    }
}