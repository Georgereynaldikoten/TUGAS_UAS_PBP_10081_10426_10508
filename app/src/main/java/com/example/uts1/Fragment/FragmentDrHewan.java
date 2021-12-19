package com.example.uts1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts1.Adapter.AdapterDrHewan;
import com.example.uts1.R;
import com.example.uts1.databinding.FragmentDrHewanBinding;
import com.example.uts1.entity.DaftarDrHewan;
import com.example.uts1.entity.Dokter;

import java.util.ArrayList;

public class FragmentDrHewan extends Fragment
{
    ArrayList<Dokter> HewanList;
    FragmentDrHewanBinding binding;

    public FragmentDrHewan() { }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dr_hewan, container,false);
        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        HewanList = new DaftarDrHewan().DrHewan;
        RecyclerView rvDrHewan= view.findViewById(R.id.rv_hewan);

        rvDrHewan.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

        rvDrHewan.setAdapter(new AdapterDrHewan(HewanList));
    }


}