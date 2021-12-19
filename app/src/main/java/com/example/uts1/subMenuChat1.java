package com.example.uts1;

import static com.example.uts1.entity.Dokter.loadImage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class subMenuChat1 extends AppCompatActivity
{
    private ImageView exit, ivDokter;
    private Button btn_chat;
    private TextView tvNama, tvSpesialis, url;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chat1);

        exit = findViewById(R.id.exit);
        btn_chat = findViewById(R.id.btn_chat);
        tvNama = findViewById(R.id.tv_nama);
        tvSpesialis = findViewById(R.id.tv_spesialis);
        ivDokter = findViewById(R.id.iv_dokter);
        url = findViewById(R.id.link);

        Intent i = getIntent();
        String nama = i.getStringExtra("nama");
        String spesialis = i.getStringExtra("spesialis");
        String imgUrl = i.getStringExtra("img");

        tvNama.setText(nama);
        tvSpesialis.setText(spesialis);
        url.setText(imgUrl);
        loadImage(ivDokter, imgUrl);

        exit.setOnClickListener(v-> {
            Intent moveMain = new Intent(subMenuChat1.this, MainActivity.class);
            startActivity(moveMain);
        });

        btn_chat.setOnClickListener(v-> {
            Intent moveSub2 = new Intent(subMenuChat1.this, subMenuChat2.class);
            String nama_dokter = tvNama.getText().toString();
            String spesialis_dokter = tvSpesialis.getText().toString();
            String url_img = url.getText().toString();

            moveSub2.putExtra("nama",nama_dokter);
            moveSub2.putExtra("spesialis",spesialis_dokter);
            moveSub2.putExtra("img",url_img);
            startActivity(moveSub2);
        });
    }

}