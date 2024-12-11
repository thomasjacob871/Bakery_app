package com.example.sucre;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainActivity6 extends AppCompatActivity
{

    private Button btn;
 LinearLayout cardContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        SharedPreferences sharedPreferenc =getSharedPreferences("New_Shared_pref",Context.MODE_PRIVATE);
        Map<String,?> allEntries = sharedPreferenc.getAll();
        Set<String> Myv= allEntries.keySet();
        SortedSet<String> sortedSet = new TreeSet<>(Myv);

        int breakpoint=sortedSet.size()/3;
        int k=sortedSet.size();
        cardContainer = findViewById(R.id.linev1);

        List<String> sortedList = new ArrayList<>(sortedSet);
        Collections.sort(sortedList);

        for(int i=0;i<breakpoint;i++){
            System.out.println(allEntries.get(sortedList.get(i)));
            System.out.println(allEntries.get(sortedList.get((i+breakpoint))));
            System.out.println(allEntries.get(sortedList.get((i+(2*breakpoint)))));

        }

        /*for(int i=0;i<breakpoint;i++){

            CardView cardView = new CardView(this);

            cardView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cardView.setCardElevation(8);
            cardView.setRadius(8);
            int color = ContextCompat.getColor(this, R.color.purple_200); // Replace with your desired color
            cardView.setCardBackgroundColor(color);

           LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new CardView.LayoutParams(
                    CardView.LayoutParams.MATCH_PARENT,
                    CardView.LayoutParams.MATCH_PARENT
            ));
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setPadding(16, 16, 16, 16);
            linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
            cardView.addView(linearLayout);

            TextView textView = new TextView(this);
            textView.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setText((CharSequence) allEntries.get(sortedList.get(i)));
            linearLayout.addView(textView);

            TextView textView1 = new TextView(this);
            textView1.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView1.setText((CharSequence) allEntries.get(sortedList.get((i+breakpoint))));
            linearLayout.addView(textView1);


            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            //imageView.setImageResource((int)); // Set the image resource
            String imageUrl = (String) allEntries.get(sortedList.get((i + (2 * breakpoint))));
            Uri imageUri = Uri.parse(imageUrl);
            Picasso.get().load(imageUri).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            linearLayout.addView(imageView);
            //cardView.setLayoutParams(layoutParams);
            cardContainer.addView(cardView);
        }*/
        int counter=0;
        for (int i = 0; i < breakpoint; i++) {
            CardView cardView = new CardView(this);
            cardView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cardView.setCardElevation(8);
            cardView.setRadius(8);
            int color = ContextCompat.getColor(this, R.color.purple_200); // Replace with your desired color
            cardView.setCardBackgroundColor(color);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(16, 16, 16, 16); // Set desired margins
            cardView.setLayoutParams(layoutParams);

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            ));
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setPadding(16, 16, 16, 16);
            linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_END);

            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setText((CharSequence) allEntries.get(sortedList.get(i)));
            linearLayout.addView(textView);

            TextView textView1 = new TextView(this);
            textView1.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView1.setText((CharSequence) allEntries.get(sortedList.get(i + breakpoint)));
            linearLayout.addView(textView1);
            String p= (String) allEntries.get(sortedList.get(i + breakpoint));
            p=p.substring(1);
            int number = Integer.parseInt(p);
            counter+=number;
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            String imageUrl = (String) allEntries.get(sortedList.get(i + (2 * breakpoint)));
            Uri imageUri = Uri.parse(imageUrl);
            Picasso.get().load(imageUri).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            linearLayout.addView(imageView);

            cardView.addView(linearLayout);
            cardContainer.addView(cardView);
        }

        TextView T1=findViewById(R.id.textView13);
        String str = Integer.toString(counter);
        T1.setText(str);



        btn = findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity6.this, Options.class));
            }
        });



    }

}