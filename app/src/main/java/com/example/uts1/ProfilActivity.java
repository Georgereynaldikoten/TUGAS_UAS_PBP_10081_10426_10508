package com.example.uts1;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationManagerCompat;

import com.example.uts1.Preferences.UserPreferences;

public class ProfilActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CAMERA = 100;
    private static final int CAMERA_REQUEST = 0;
    private static final int GALLERY_PICTURE = 1;
    UserPreferences userPreferences;
    private NotificationManagerCompat notificationManager;

    private Camera mCamera = null;
    private CameraView mCameraView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        userPreferences = new UserPreferences(ProfilActivity.this);
        TextView tvNama,tvJenisKelamin,tvAlamat,tvEmail,tvNoTelp,tvUbah;
        CardView cvKeluar,cvLokasi,cvReminder,cvKeluarga;

        ImageView ivBack, ivCamera;


        tvNama = findViewById(R.id.tv_nama);
        tvJenisKelamin = findViewById(R.id.tv_jenisKelamin);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvEmail = findViewById(R.id.tv_email);
        tvNoTelp = findViewById(R.id.tv_noTelp);
        cvKeluar = findViewById(R.id.cv_keluar);
        cvLokasi = findViewById(R.id.lokasi);
        cvReminder = findViewById(R.id.cv_reminder);
        cvKeluarga = findViewById(R.id.cv_keluarga);
        ivBack = findViewById(R.id.iv_back);
        ivCamera = findViewById(R.id.iv_camera);
        tvUbah = findViewById(R.id.tv_ubah);

        userPreferences.getUserLogin();
        checkLogin();
        tvNama.setText(userPreferences.getUserLogin().getName());
        tvAlamat.setText(userPreferences.getUserLogin().getAlamat());
        tvJenisKelamin.setText(userPreferences.getUserLogin().getJenisKelamin());
        tvEmail.setText(userPreferences.getUserLogin().getEmail());
        tvNoTelp.setText(userPreferences.getUserLogin().getNoTelp());

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilActivity.this, MainActivity.class));
            }
        });

        tvUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilActivity.this, EditActivity.class));
            }
        });

        cvLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilActivity.this, LokasiActivity.class));
            }
        });

        cvReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilActivity.this, ReminderActivity.class));
            }
        });


        cvKeluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilActivity.this, RoomActivity.class));
            }
        });

        cvKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPreferences.logout();
                Toast.makeText(ProfilActivity.this, "Selamat Tinggal",
                        Toast.LENGTH_SHORT)
                        .show();
                checkLogin();
            }
        });

        ivCamera.setOnClickListener(new View.OnClickListener() {
            LayoutInflater layoutInflater =
                    LayoutInflater.from(ProfilActivity.this);
            View selectMediaView = layoutInflater
                    .inflate(R.layout.layout_select_media, null);
            final AlertDialog alertDialog = new AlertDialog
                    .Builder(selectMediaView.getContext()).create();
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater =
                        LayoutInflater.from(ProfilActivity.this);
                View selectMediaView = layoutInflater
                        .inflate(R.layout.layout_select_media, null);
                final AlertDialog alertDialog = new AlertDialog
                        .Builder(selectMediaView.getContext()).create();
                Button btnKamera = selectMediaView.findViewById(R.id.btn_kamera);
                Button btnGaleri = selectMediaView.findViewById(R.id.btn_galeri);
                btnKamera.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) ==
                                PackageManager.PERMISSION_DENIED) {
                            String[] permission = {Manifest.permission.CAMERA};
                            requestPermissions(permission, PERMISSION_REQUEST_CAMERA);
                        } else {
                            // Membuka kamera
                            Intent intent =
                                    new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, CAMERA_REQUEST);
                        }
                        alertDialog.dismiss();
                    }
                });
                btnGaleri.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Membuka galeri
                        Intent intent = new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, GALLERY_PICTURE);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.setView(selectMediaView);
                alertDialog.show();
            }
        });


    }

    private void checkLogin() {
        if (!userPreferences.checkLogin()){
            startActivity(new Intent(ProfilActivity.this, LoginActivity.class));
        }
    }
}
