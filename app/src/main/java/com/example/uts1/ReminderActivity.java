package com.example.uts1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.uts1.API.APIRequestData;
import com.example.uts1.API.RetrofitServer;
import com.example.uts1.Adapter.AdapterReminder;
import com.example.uts1.Model.ReminderModel;
import com.example.uts1.Model.ResponseModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReminderActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private SwipeRefreshLayout swlData;
    private ProgressBar pbData;
    private FloatingActionButton fabTambah;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List <ReminderModel> listReminder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_reminder);

        fabTambah = findViewById(R.id.fab_tambah);
        swlData = findViewById(R.id.swl_data);
        pbData = findViewById(R.id.pb_data);
        rvData = findViewById(R.id.rv_reminder);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        swlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swlData.setRefreshing(true);
                retrieveData();
                swlData.setRefreshing(false);
            }
        });

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReminderActivity.this, TambahActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData(){
        pbData.setVisibility(View.VISIBLE);
        APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
//                Toast.makeText(ReminderActivity.this, "Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();

                listReminder = response.body().getData();

                adData = new AdapterReminder(ReminderActivity.this, listReminder);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(ReminderActivity.this, "Connect Failed"+t.getMessage(), Toast.LENGTH_SHORT).show();

                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }


}
