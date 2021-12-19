package com.example.uts1;

import static com.example.uts1.entity.Dokter.loadImage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class subMenuChat2 extends AppCompatActivity
{
    private ImageView back, ivDokter;
    private Button btn_chat;
    private TextView tvNama, tvSpesialis, url;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chat2);

        back = findViewById(R.id.exit);
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

        back.setOnClickListener(v-> {
            Intent moveSub1 = new Intent(subMenuChat2.this, subMenuChat1.class);
            startActivity(moveSub1);
        });

        btn_chat.setOnClickListener(v-> {
            Intent moveSub3 = new Intent(subMenuChat2.this, subMenuChat3.class);
            String nama_dokter = tvNama.getText().toString();
            String spesialis_dokter = tvSpesialis.getText().toString();
            String url_img = url.getText().toString();

            moveSub3.putExtra("nama",nama_dokter);
            moveSub3.putExtra("spesialis",spesialis_dokter);
            moveSub3.putExtra("img",url_img);
            startActivity(moveSub3);
        });
    }
}