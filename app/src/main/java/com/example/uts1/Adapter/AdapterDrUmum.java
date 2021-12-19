package com.example.uts1.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts1.DetailDokter;
import com.example.uts1.R;
import com.example.uts1.databinding.RvItemUmumBinding;
import com.example.uts1.entity.Dokter;

import java.util.ArrayList;

public class AdapterDrUmum extends RecyclerView.Adapter<AdapterDrUmum.viewHolder>
{
    private ArrayList<Dokter> UmumList;

    public AdapterDrUmum(ArrayList<Dokter> UmumList)
    {
        this.UmumList = UmumList;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        private RvItemUmumBinding binding;

        public viewHolder(@NonNull RvItemUmumBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;

            binding.tvCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getLayoutPosition();
                    Intent detail= new Intent(view.getContext(), DetailDokter.class);
                    Dokter Umum = UmumList.get(pos);
                    detail.putExtra("img", Umum.getImgURL());
                    detail.putExtra("nama", Umum.getNama());
                    detail.putExtra("str", Umum.getNo_str());
                    detail.putExtra("spesialis", Umum.getSpesialis());
                    detail.putExtra("praktik", Umum.getTempat_praktik());
                    detail.putExtra("jadwal", Umum.getJadwal());
                    view.getContext().startActivity(detail);
                }
            });
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new viewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.rv_item_umum, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Dokter DrUmum = UmumList.get(position);
        holder.binding.setUmum(DrUmum);
    }

    @Override
    public int getItemCount()
    {
        return UmumList.size();
    }

}
