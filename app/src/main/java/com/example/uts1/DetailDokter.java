package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailDokter extends AppCompatActivity
{
    private ImageView arrow_back;
    private Button btn_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        arrow_back = findViewById(R.id.arrow_back);
        btn_chat = findViewById(R.id.button_chat);

        btn_chat.setOnClickListener( v-> {
                Intent moveSub1 = new Intent(DetailDokter.this, subMenuChat1.class);
                startActivity(moveSub1);
        });

        arrow_back.setOnClickListener(view -> {
            Intent moveMain = new Intent(DetailDokter.this, MainActivity.class);
            startActivity(moveMain);
        });
    }
}