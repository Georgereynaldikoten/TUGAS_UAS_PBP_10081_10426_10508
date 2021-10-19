package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView menuNavigation;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterDrUmum adapterDrUmum;
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

        viewPagerAdapter.AddFragment(new FragmentDrUmum(),"Umum");
        viewPagerAdapter.AddFragment(new FragmentDrHewan(),"Hewan");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}