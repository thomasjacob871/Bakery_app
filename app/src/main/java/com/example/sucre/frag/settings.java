package com.example.sucre.frag;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.sucre.MainActivity;

import com.example.sucre.MainActivity6;
import com.example.sucre.R;

public class settings extends Fragment {

    private CardView cardview;
    CardView c1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
       cardview = rootView.findViewById(R.id.logout);
       c1=rootView.findViewById(R.id.crdview11);
       c1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intee=new Intent(getActivity(), MainActivity6.class);
               startActivity(intee);
           }
       });
       cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                //Context settings;
                //Toast.makeText(getActivity(),"Log out successful",Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;

    }


}

