package com.example.uts1;

import static com.example.uts1.entity.Dokter.loadImage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailDokter extends AppCompatActivity
{
    private ImageView arrow_back, iv_dokter;
    private Button btn_chat;
    private TextView tvNama, tvSpesialis, tvStr, tvJadwal, tvPraktik, url;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        arrow_back = findViewById(R.id.arrow_back);
        btn_chat = findViewById(R.id.button_chat);
        tvNama = findViewById(R.id.tv_nama);
        tvSpesialis = findViewById(R.id.tv_spesialis);
        tvStr = findViewById(R.id.tv_str);
        tvJadwal = findViewById(R.id.tv_jadwal);
        tvPraktik = findViewById(R.id.tv_praktik);
        iv_dokter = findViewById(R.id.photo_dokter);
        url = findViewById(R.id.link);

        Intent i = getIntent();
        String nama = i.getStringExtra("nama");
        String spesialis = i.getStringExtra("spesialis");
        String imgUrl = i.getStringExtra("img");

        tvNama.setText(nama);
        tvSpesialis.setText(spesialis);
        tvStr.setText(i.getStringExtra("str"));
        tvPraktik.setText(i.getStringExtra("praktik"));
        tvJadwal.setText(i.getStringExtra("jadwal"));
        url.setText(imgUrl);
        loadImage(iv_dokter, imgUrl);

        btn_chat.setOnClickListener( v-> {
                Intent moveSub1 = new Intent(DetailDokter.this, subMenuChat1.class);
                String nama_dokter = tvNama.getText().toString();
                String spesialis_dokter = tvSpesialis.getText().toString();
                String url_img = url.getText().toString();

                moveSub1.putExtra("nama",nama_dokter);
                moveSub1.putExtra("spesialis",spesialis_dokter);
                moveSub1.putExtra("img",url_img);
                startActivity(moveSub1);
        });

        arrow_back.setOnClickListener(view -> {
            Intent moveMain = new Intent(DetailDokter.this, MainActivity.class);
            startActivity(moveMain);
        });
    }
}