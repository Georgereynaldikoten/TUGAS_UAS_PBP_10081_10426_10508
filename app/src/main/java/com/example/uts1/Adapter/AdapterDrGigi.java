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
import com.example.uts1.databinding.RvItemGigiBinding;
import com.example.uts1.entity.Dokter;

import java.util.ArrayList;

public class AdapterDrGigi extends RecyclerView.Adapter<AdapterDrGigi.viewHolder>
{
    private ArrayList<Dokter> GigiList;

    public AdapterDrGigi(ArrayList<Dokter> GigiList)
    {
        this.GigiList = GigiList;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        private RvItemGigiBinding binding;

        public viewHolder(@NonNull RvItemGigiBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;

            binding.tvCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getLayoutPosition();
                    Intent detail= new Intent(view.getContext(), DetailDokter.class);
                    Dokter Gigi = GigiList.get(pos);
                    detail.putExtra("img", Gigi.getImgURL());
                    detail.putExtra("nama", Gigi.getNama());
                    detail.putExtra("str", Gigi.getNo_str());
                    detail.putExtra("spesialis", Gigi.getSpesialis());
                    detail.putExtra("praktik", Gigi.getTempat_praktik());
                    detail.putExtra("jadwal", Gigi.getJadwal());
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
                R.layout.rv_item_gigi, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        Dokter DrGigi = GigiList.get(position);
        holder.binding.setGigi(DrGigi);
    }

    @Override
    public int getItemCount()
    {
        return GigiList.size();
    }

}
