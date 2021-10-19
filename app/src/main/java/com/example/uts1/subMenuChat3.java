package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class subMenuChat3 extends AppCompatActivity
{
    private ImageView close;
    private CardView gopay, ovo, bni;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chat3);

        close = findViewById(R.id.exit);
        gopay = findViewById(R.id.layout_gopay);
        ovo = findViewById(R.id.layout_ovo);
        bni = findViewById(R.id.layout_bni);

        close.setOnClickListener(v-> {
            Intent moveMain = new Intent(subMenuChat3.this, subMenuChat2.class);
            startActivity(moveMain);
        });

        gopay.setOnClickListener(v-> {

        });

        ovo.setOnClickListener(v-> {

        });

        bni.setOnClickListener(v->{

        });
    }
}