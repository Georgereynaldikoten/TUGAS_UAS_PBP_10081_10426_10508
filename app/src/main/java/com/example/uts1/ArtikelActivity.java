package com.example.uts1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.uts1.Adapter.AdapterArtikel;
import com.example.uts1.entity.Artikel;
import com.example.uts1.entity.DaftarArtikel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ArtikelActivity extends AppCompatActivity
{
    private BottomNavigationView menuNavigation;
    ArrayList<Artikel> ArtikelList;
    ViewDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);
        menuNavigation = findViewById(R.id.bottom_navigation);

        menuNavigation.setSelectedItemId(R.id.menu_artikel);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artikel);

        ArtikelList = new DaftarArtikel().artikel;
        RecyclerView rvArtikel = findViewById(R.id.recyclerView);

        rvArtikel.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        rvArtikel.setAdapter(new AdapterArtikel(ArtikelList));


        menuNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_chat) {
                    startActivity(new Intent(ArtikelActivity.this, MainActivity.class));
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.menu_artikel) {
                    startActivity(new Intent(ArtikelActivity.this, ArtikelActivity.class));
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.menu_profil) {
                    startActivity(new Intent(ArtikelActivity.this, ProfilActivity.class));
                    finish();
                    return true;
                }

                return false;
            }
        });

    }
}