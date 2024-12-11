package com.example.sucre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity3 extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    adapter1 adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        tabLayout = findViewById(R.id.tblay);
        viewPager2 = findViewById(R.id.viewpg);
        adapter1 = new adapter1(this);
        viewPager2.setAdapter(adapter1);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();

            }

        });
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i("State","onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i("State","onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i("State","onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("State","onStop");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i("State","onRestart");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("State","onDestroy");
    }

}

