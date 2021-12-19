package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;

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

public class TambahActivity extends AppCompatActivity {
    private EditText etJudul,etDeskripsi,etWaktu;
    private Button btnTambah;

    private String judul,deskripsi,waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etJudul =findViewById(R.id.et_judulReminder);
        etDeskripsi = findViewById(R.id.et_deskripsiReminder);
        etWaktu = findViewById(R.id.et_waktuReminder);
        btnTambah = findViewById(R.id.btn_simpanReminder);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judul = etJudul.getText().toString();
                deskripsi = etDeskripsi.getText().toString();
                waktu = etWaktu.getText().toString();

                if(judul.trim().equals("")){
                    etJudul.setError("Judul Tidak Boleh Kosong");
                }else if(deskripsi.trim().equals("")){
                    etDeskripsi.setError("Deskripsi Tidak Boleh Kosong");
                }else if(waktu.trim().equals("")){
                    etWaktu.setError("Waktu Tidak Boleh Kosong");
                }else{
                    createData();
                }
            }
        });
    }
    private void createData(){
        APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(judul,deskripsi,waktu);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(TambahActivity.this,"Gagal Menyambungkan ke Server | "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}