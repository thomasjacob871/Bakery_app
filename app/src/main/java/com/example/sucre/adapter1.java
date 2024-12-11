package com.example.sucre;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sucre.frag.home;
import com.example.sucre.frag.settings;

public class adapter1 extends FragmentStateAdapter
{
    public adapter1(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        switch (position)
        {
            case 0:
                return new home();
            case 1:
                return new settings();
            default:
                return new home();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
