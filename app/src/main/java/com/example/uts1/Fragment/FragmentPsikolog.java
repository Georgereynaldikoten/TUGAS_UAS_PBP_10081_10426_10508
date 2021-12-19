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

import com.example.uts1.Adapter.AdapterPsikolog;
import com.example.uts1.R;
import com.example.uts1.databinding.FragmentPsikologBinding;
import com.example.uts1.entity.DaftarPsikolog;
import com.example.uts1.entity.Dokter;

import java.util.ArrayList;

public class FragmentPsikolog extends Fragment
{

    ArrayList<Dokter> PsikologList;
    FragmentPsikologBinding binding;

    public FragmentPsikolog() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_psikolog, container,false);
        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        PsikologList = new DaftarPsikolog().Psikolog;
        RecyclerView rvPsikolog= view.findViewById(R.id.rv_psikolog);

        rvPsikolog.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

        rvPsikolog.setAdapter(new AdapterPsikolog(PsikologList));
    }
}