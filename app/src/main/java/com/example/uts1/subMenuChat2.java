package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class subMenuChat2 extends AppCompatActivity
{
    private ImageView back;
    private Button btn_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chat2);

        back = findViewById(R.id.exit);
        btn_chat = findViewById(R.id.btn_chat);

        back.setOnClickListener(v-> {
            Intent moveSub1 = new Intent(subMenuChat2.this, subMenuChat1.class);
            startActivity(moveSub1);
        });

        btn_chat.setOnClickListener(v-> {
            Intent moveSub3 = new Intent(subMenuChat2.this, subMenuChat3.class);
            startActivity(moveSub3);
        });
    }
}