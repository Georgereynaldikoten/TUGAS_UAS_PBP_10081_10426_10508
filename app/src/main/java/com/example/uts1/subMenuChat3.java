package com.example.uts1;

import static com.example.uts1.App.CHANNEL_1_ID;
import static com.example.uts1.entity.Dokter.loadImage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class subMenuChat3 extends AppCompatActivity
{
    private NotificationManagerCompat notificationManager;
    private ImageView close, ivDokter;
    private CardView gopay, ovo, bni;
    private TextView tvNama, tvSpesialis;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chat3);

        close = findViewById(R.id.exit);
        gopay = findViewById(R.id.layout_gopay);
        ovo = findViewById(R.id.layout_ovo);
        bni = findViewById(R.id.layout_bni);
        tvNama = findViewById(R.id.tv_nama);
        tvSpesialis = findViewById(R.id.tv_spesialis);
        ivDokter = findViewById(R.id.iv_dokter);

        notificationManager = NotificationManagerCompat.from(this);

        Intent i = getIntent();
        String nama = i.getStringExtra("nama");
        String spesialis = i.getStringExtra("spesialis");
        String imgUrl = i.getStringExtra("img");

        tvNama.setText(nama);
        tvSpesialis.setText(spesialis);
        loadImage(ivDokter, imgUrl);

        close.setOnClickListener(v->
        {
            Intent moveMain = new Intent(subMenuChat3.this, subMenuChat2.class);
            startActivity(moveMain);
        });

        gopay.setOnClickListener(v->
        {
            Toast.makeText(subMenuChat3.this,"Pembayaran Berhasil", Toast.LENGTH_SHORT).show();

            Intent moveMain = new Intent(subMenuChat3.this, MainActivity.class);
            startActivity(moveMain);
        });

        bni.setOnClickListener(v->
        {
            Toast.makeText(subMenuChat3.this,"Pembayaran Berhasil", Toast.LENGTH_SHORT).show();

            Intent moveMain = new Intent(subMenuChat3.this, MainActivity.class);
            startActivity(moveMain);

        });

        ovo.setOnClickListener(v->
        {
            Toast.makeText(subMenuChat3.this,"Pembayaran Berhasil", Toast.LENGTH_SHORT).show();

            Intent moveMain = new Intent(subMenuChat3.this, MainActivity.class);
            startActivity(moveMain);
        });
    }

    public void sendOnChannel1(View v)
    {
        /*NotificationCompat.Builder notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.halosehat)
                .setContentTitle("Pembayaran Berhasil")
                .setContentText("Selamat menikmati layanan dari HaloSehat!")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(1,notification.build());

         */

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent = new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage","Pembayaran Berhasil");
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.halosehat)
                .setContentTitle("Pembayaran Berhasil")
                .setContentText("Selamat menikmati layanan dari HaloSehat!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .build();

        notificationManager.notify(1,notification);
    }
}