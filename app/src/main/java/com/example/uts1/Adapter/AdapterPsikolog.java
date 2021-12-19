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
import com.example.uts1.databinding.RvItemPsikologBinding;
import com.example.uts1.entity.Dokter;

import java.util.ArrayList;

public class AdapterPsikolog extends RecyclerView.Adapter<AdapterPsikolog.viewHolder>
{
    private ArrayList<Dokter> PsikologList;

    public AdapterPsikolog(ArrayList<Dokter> PsikologList)
    {
        this.PsikologList = PsikologList;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        private RvItemPsikologBinding binding;

        public viewHolder(@NonNull RvItemPsikologBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;

            binding.tvCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    int pos = getLayoutPosition();
                    Intent detail= new Intent(view.getContext(), DetailDokter.class);
                    Dokter Psikolog = PsikologList.get(pos);
                    detail.putExtra("img", Psikolog.getImgURL());
                    detail.putExtra("nama", Psikolog.getNama());
                    detail.putExtra("str", Psikolog.getNo_str());
                    detail.putExtra("spesialis", Psikolog.getSpesialis());
                    detail.putExtra("praktik", Psikolog.getTempat_praktik());
                    detail.putExtra("jadwal", Psikolog.getJadwal());
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
                R.layout.rv_item_psikolog, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        Dokter Psikolog = PsikologList.get(position);
        holder.binding.setPsikolog(Psikolog);
    }

    @Override
    public int getItemCount()
    {
        return PsikologList.size();
    }

}
