package com.example.uts1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.uts1.Adapter.AdapterDrUmum;
import com.example.uts1.Adapter.ViewPagerAdapter;
import com.example.uts1.Fragment.FragmentDrGigi;
import com.example.uts1.Fragment.FragmentDrHewan;
import com.example.uts1.Fragment.FragmentDrUmum;
import com.example.uts1.Fragment.FragmentPsikolog;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView menuNavigation;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuNavigation = findViewById(R.id.bottom_navigation);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.AddFragment(new FragmentDrUmum(), "Umum");
        viewPagerAdapter.AddFragment(new FragmentDrHewan(), "Hewan");
        viewPagerAdapter.AddFragment(new FragmentPsikolog(), "Psikolog");
        viewPagerAdapter.AddFragment(new FragmentDrGigi(), "Gigi");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        menuNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_artikel) {
                    startActivity(new Intent(MainActivity.this, ArtikelActivity.class));
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.menu_chat) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.menu_profil) {
                    startActivity(new Intent(MainActivity.this, ProfilActivity.class));
                    finish();
                    return true;
                }

                return false;
            }
        });
    }


}