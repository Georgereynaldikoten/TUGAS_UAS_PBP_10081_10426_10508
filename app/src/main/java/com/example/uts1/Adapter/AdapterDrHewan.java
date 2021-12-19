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
import com.example.uts1.databinding.RvItemHewanBinding;
import com.example.uts1.entity.Dokter;

import java.util.ArrayList;

public class AdapterDrHewan extends RecyclerView.Adapter<AdapterDrHewan.viewHolder>
{
    private ArrayList<Dokter> HewanList;

    public AdapterDrHewan(ArrayList<Dokter> HewanList)
    {
        this.HewanList = HewanList;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        private RvItemHewanBinding binding;

        public viewHolder(@NonNull RvItemHewanBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;

            binding.tvCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getLayoutPosition();
                    Intent detail= new Intent(view.getContext(), DetailDokter.class);
                    Dokter Hewan = HewanList.get(pos);
                    detail.putExtra("img", Hewan.getImgURL());
                    detail.putExtra("nama", Hewan.getNama());
                    detail.putExtra("str", Hewan.getNo_str());
                    detail.putExtra("spesialis", Hewan.getSpesialis());
                    detail.putExtra("praktik", Hewan.getTempat_praktik());
                    detail.putExtra("jadwal", Hewan.getJadwal());
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
                R.layout.rv_item_hewan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        Dokter DrHewan = HewanList.get(position);
        holder.binding.setHewan(DrHewan);
    }

    @Override
    public int getItemCount()
    {
        return HewanList.size();
    }

}
