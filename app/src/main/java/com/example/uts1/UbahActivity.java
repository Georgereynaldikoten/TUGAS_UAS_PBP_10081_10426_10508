package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts1.API.APIRequestData;
import com.example.uts1.API.RetrofitServer;
import com.example.uts1.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahActivity extends AppCompatActivity {
    private int xId;
    private  String xJudul,xDeskripsi,xWaktu;
    private EditText etJudul, etDeskripsi, etWaktu;
    private Button btnEdit;
    private String yJudul,yDeskripsi,yWaktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        Intent terima = getIntent();
        xId = terima.getIntExtra("xId",-1);
        xDeskripsi = terima.getStringExtra("xDeskripsi");
        xJudul = terima.getStringExtra("xJudul");
        xWaktu = terima.getStringExtra("xWaktu");

        etJudul = findViewById(R.id.et_judulReminder);
        etDeskripsi = findViewById(R.id.et_deskripsiReminder);
        etWaktu = findViewById(R.id.et_waktuReminder);
        btnEdit = findViewById(R.id.btn_editReminder);

        etJudul.setText(xJudul);
        etDeskripsi.setText(xDeskripsi);
        etWaktu.setText(xWaktu);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yJudul = etJudul.getText().toString();
                yDeskripsi = etDeskripsi.getText().toString();
                yWaktu = etWaktu.getText().toString();


                updateData();
            }
        });
    }
    private void updateData(){
        APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> updateData = ardData.ardUpdateData(xId,yJudul,yDeskripsi,yWaktu);

        updateData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(UbahActivity.this,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UbahActivity.this,"Gagal Menyambungkan ke Server | "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}