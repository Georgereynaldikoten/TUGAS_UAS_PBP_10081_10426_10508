package com.example.uts1.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts1.IsiArtikelActivity;
import com.example.uts1.R;
import com.example.uts1.databinding.RvArtikelBinding;
import com.example.uts1.entity.Artikel;

import java.util.ArrayList;

public class AdapterArtikel extends RecyclerView.Adapter<AdapterArtikel.viewHolder>
{
    private ArrayList<Artikel> ArtikelList;

    public AdapterArtikel(ArrayList<Artikel> ArtikelList)
    {
        this.ArtikelList = ArtikelList;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        private RvArtikelBinding binding;

        public viewHolder(@NonNull RvArtikelBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;

            binding.tvCard.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int pos = getLayoutPosition();
                    Intent detail= new Intent(view.getContext(), IsiArtikelActivity.class);
                    Artikel artikel = ArtikelList.get(pos);
                    detail.putExtra("img", artikel.getGambar());
                    detail.putExtra("tag", artikel.getTag());
                    detail.putExtra("judul", artikel.getJudul());
                    detail.putExtra("deskripsi", artikel.getDekripsi());
                    detail.putExtra("isi", artikel.getIsi());
                    view.getContext().startActivity(detail);
                }
            });
        }
    }

    @NonNull
    @Override
    public AdapterArtikel.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new AdapterArtikel.viewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.rv_artikel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArtikel.viewHolder holder, int position)
    {
        Artikel artikel = ArtikelList.get(position);
        holder.binding.setArtikel(artikel);
    }

    @Override
    public int getItemCount()
    {
        return ArtikelList.size();
    }
}
