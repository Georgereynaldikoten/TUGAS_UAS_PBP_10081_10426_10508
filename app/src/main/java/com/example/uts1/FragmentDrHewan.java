package com.example.uts1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDrHewan extends Fragment
{
    public FragmentDrHewan() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dr_hewan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Menghubungkan rvMahasiswa dengan recycler view yang ada pada layout
        RecyclerView rvDrHewan= view.findViewById(R.id.rv_Dokter);

        //  Set Layout Manager dari recycler view
        rvDrHewan.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

        //  Set Adapter dari recycler view.
        //rvDrHewan.setAdapter(new RVDrHewanAdapter(dokterHewan.listOfDokter));
    }
}