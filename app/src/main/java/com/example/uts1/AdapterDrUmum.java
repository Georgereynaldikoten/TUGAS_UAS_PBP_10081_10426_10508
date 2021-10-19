package com.example.uts1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDrUmum extends RecyclerView.Adapter<AdapterDrUmum.viewHolder>
{
    //  Attribute listMahasiswa kita pada adapter
    //private ArrayList<DataPeserta> PesertaList;

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView tvNama;
        TextView tvDetails;

        public viewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDetails = itemView.findViewById(R.id.tv_details);
        }
    }

    @NonNull
    @Override
    public AdapterDrUmum.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
        //return new viewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        //                R.layout.activity_recycler_view_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDrUmum.viewHolder holder, int position) {
        //DataPeserta dataPeserta = PesertaList.get(position);
        //        holder.binding.setPst(dataPeserta);
    }

    @Override
    public int getItemCount()
    {
        return 0;
        //return PesertaList.size();
    }

}
