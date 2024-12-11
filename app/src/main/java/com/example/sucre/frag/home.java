package com.example.sucre.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sucre.Biscuit;
import com.example.sucre.Bread;
import com.example.sucre.Donuts;
import com.example.sucre.MainActivity5;
import com.example.sucre.Pstrie;
import com.example.sucre.R;
import com.example.sucre.beverages;
import com.example.sucre.burgers;
import com.example.sucre.cokie;
import com.example.sucre.sweets;


public class home extends Fragment
{
    public CardView cardview;
    public CardView crdview,crdview1,crdview12,crdview13,crdview14,crdview15,crdview16,crdview17;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView1 = inflater.inflate(R.layout.fragment_home, container, false);
        cardview = rootView1.findViewById(R.id.crdview3);
        crdview=rootView1.findViewById(R.id.crdview4);
        crdview1=rootView1.findViewById(R.id.crdview6);
        crdview12=rootView1.findViewById(R.id.crdview2);
        crdview13=rootView1.findViewById(R.id.crdview8);
        crdview14=rootView1.findViewById(R.id.crdview5);
        crdview15=rootView1.findViewById(R.id.crdview7);
        crdview16=rootView1.findViewById(R.id.crdview23);
        crdview17=rootView1.findViewById(R.id.crdview9);


        crdview12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), cokie.class);
                startActivity(intent);
            }
        });
        crdview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), Bread.class);
                startActivity(intent);
            }
        });
        crdview1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), Biscuit.class);
                startActivity(intent);
            }
        });
        cardview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), MainActivity5.class);
                startActivity(intent);
                //Context settings;
                //Toast.makeText(getActivity(),"Log out successful",Toast.LENGTH_SHORT).show();
            }
        });

        crdview13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), sweets.class);
                startActivity(intent);

            }
        });

        crdview14.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), Donuts.class);
                startActivity(intent);

            }
        });

        crdview15.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), Pstrie.class);
                startActivity(intent);

            }
        });

        crdview16.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), burgers.class);
                startActivity(intent);

            }
        });

        crdview17.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), beverages.class);
                startActivity(intent);

            }
        });


        //return inflater.inflate(R.layout.fragment_home, container, false);
        return rootView1;

    }
        // Inflate the layout for this fragment

    }
