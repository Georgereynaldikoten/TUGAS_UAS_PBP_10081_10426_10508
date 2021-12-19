package com.example.uts1.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts1.API.APIRequestData;
import com.example.uts1.API.RetrofitServer;
import com.example.uts1.LoginActivity;
import com.example.uts1.Model.ReminderModel;
import com.example.uts1.Model.ResponseModel;
import com.example.uts1.R;
import com.example.uts1.ReminderActivity;
import com.example.uts1.SplashScreen;
import com.example.uts1.UbahActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterReminder extends RecyclerView.Adapter<AdapterReminder.HolderData> {
    private Context context;
    private List<ReminderModel> listModel;
    private  List<ReminderModel>  listReminder;
    private int idReminder;

    public AdapterReminder(Context context, List<ReminderModel> listModel) {
        this.context = context;
        this.listModel = listModel;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_reminder, parent, false);
                HolderData holder = new HolderData(layout);
                        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ReminderModel reminder = listModel.get(position);

        holder.tvID.setText(String.valueOf(reminder.getId()));
        holder.tvJudul.setText(reminder.getJudul());
        holder.tvDeskripsi.setText(reminder.getDeskripsi());
        holder.tvWaktu.setText(reminder.getWaktu());
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvJudul, tvDeskripsi, tvWaktu, tvID;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvID = itemView.findViewById(R.id.tv_idReminder);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvWaktu = itemView.findViewById(R.id.tv_waktu);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(context);
                    dialogPesan.setMessage("Choose Action");
                    dialogPesan.setTitle("Alert");
                    dialogPesan.setIcon(R.mipmap.ic_launcher_round);
                    dialogPesan.setCancelable(true);

                    idReminder = Integer.parseInt(tvID.getText().toString());

                    dialogPesan.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                            final android.os.Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ((ReminderActivity)context).retrieveData();
                                }
                            }, 1000L);

                        }
                    });

                    dialogPesan.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogPesan.show();

                    return false;
                }
            });
        }

        private void deleteData(){
            APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idReminder);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    Toast.makeText(context,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                    Toast.makeText(context,"Gagal Menyambungkan Ke Server :"+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        private void getData(){
            APIRequestData ardData = RetrofitServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> ambilData = ardData.ardGetData(idReminder);

            ambilData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    listReminder = response.body().getData();

                    int varIdReminder = listReminder.get(0).getId();
                    String varJudulReminder = listReminder.get(0).getJudul();
                    String varDeskripsiReminder = listReminder.get(0).getDeskripsi();
                    String varWaktuReminder = listReminder.get(0).getWaktu();


//                    Toast.makeText(context,"Kode : "+kode+" | Pesan : "+pesan+" | Data : "+varIdReminder+ " | "+varJudulReminder+" | "+varDeskripsiReminder+" | "+varWaktuReminder,Toast.LENGTH_LONG).show();
                    Intent kirim = new Intent(context, UbahActivity.class);
                    kirim.putExtra("xId",varIdReminder);
                    kirim.putExtra("xDeskripsi",varDeskripsiReminder);
                    kirim.putExtra("xJudul",varJudulReminder);
                    kirim.putExtra("xWaktu",varWaktuReminder);


                    context.startActivity(kirim);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                    Toast.makeText(context,"Gagal Menyambungkan Ke Server :"+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
