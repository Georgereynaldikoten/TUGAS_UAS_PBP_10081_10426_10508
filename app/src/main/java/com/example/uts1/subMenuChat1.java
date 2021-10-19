package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class subMenuChat1 extends AppCompatActivity
{
    private ImageView exit;
    private Button btn_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chat1);

        exit = findViewById(R.id.exit);
        btn_chat = findViewById(R.id.btn_chat);

        exit.setOnClickListener(v-> {
            Intent moveMain = new Intent(subMenuChat1.this, MainActivity.class);
            startActivity(moveMain);
        });

        btn_chat.setOnClickListener(v-> {
            Intent moveSub2 = new Intent(subMenuChat1.this, subMenuChat2.class);
            startActivity(moveSub2);
        });
    }
}