package com.example.sucre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class beverages extends AppCompatActivity
{
    TextView[] t1=new TextView[10];
    TextView[] t2=new TextView[10];
    ImageView[] I3=new ImageView[10];

    ImageButton[]imagbut=new ImageButton[10];

    public String A,B,C;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);

        imagbut[0]=findViewById(R.id.imageButton23);
        imagbut[1]=findViewById(R.id.imageButton2);
        imagbut[2]=findViewById(R.id.imageButton24);
        imagbut[3]=findViewById(R.id.imageButton21);
        imagbut[4]=findViewById(R.id.imageButton34);
        imagbut[5]=findViewById(R.id.imageButton31);
        imagbut[6]=findViewById(R.id.imageButton53);
        imagbut[7]=findViewById(R.id.imageButton55);
        imagbut[8]=findViewById(R.id.imageButton40);
        imagbut[9]=findViewById(R.id.imageButton4);

        t1[0]=findViewById(R.id.textView100);
        t1[1]=findViewById(R.id.textView102);
        t1[2]=findViewById(R.id.textView200);
        t1[3]=findViewById(R.id.textView207);
        t1[4]=findViewById(R.id.textView300);
        t1[5]=findViewById(R.id.textView307);
        t1[6]=findViewById(R.id.textView500);
        t1[7]=findViewById(R.id.textView505);
        t1[8]=findViewById(R.id.textView400);
        t1[9]=findViewById(R.id.textView405);

        t2[0]=findViewById(R.id.textView82);
        t2[1]=findViewById(R.id.textView103);
        t2[2]=findViewById(R.id.textView201);
        t2[3]=findViewById(R.id.textView205);
        t2[4]=findViewById(R.id.textView301);
        t2[5]=findViewById(R.id.textView305);
        t2[6]=findViewById(R.id.textView501);
        t2[7]=findViewById(R.id.textView503);
        t2[8]=findViewById(R.id.textView40q);
        t2[9]=findViewById(R.id.textView403);

        I3[0]=findViewById(R.id.imageView12);
        I3[1]=findViewById(R.id.imageView21);
        I3[2]=findViewById(R.id.imageView22);
        I3[3]=findViewById(R.id.imageView23);
        I3[4]=findViewById(R.id.imageView31);
        I3[5]=findViewById(R.id.imageView42);
        I3[6]=findViewById(R.id.imageView18);
        I3[7]=findViewById(R.id.imageView19);
        I3[8]=findViewById(R.id.imageView101);
        I3[9]=findViewById(R.id.imageView102);

        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference().child("beverages").child("image");
        DatabaseReference ref2=FirebaseDatabase.getInstance().getReference().child("beverages").child("name");
        DatabaseReference ref3=FirebaseDatabase.getInstance().getReference().child("beverages").child("value");


        ValueEventListener newlistner1=new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String[] rei=new String[10];
                int i=0;
                int j=0;
                int z=0;
                if(snapshot.exists())
                {
                    for (DataSnapshot d : snapshot.getChildren())
                    {
                        rei[i] = (String) d.getValue();
                        Picasso.get().load(rei[i]).fit().centerCrop().into(I3[i]);
                        i++;
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        };
        ValueEventListener newlistner2=new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String[] rei = new String[10];
                int i = 0;
                if (snapshot.exists())
                {
                    for (DataSnapshot d : snapshot.getChildren())
                    {
                        rei[i] = (String) d.getValue();
                        t1[i].setText(rei[i]);
                        i++;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        };
        ValueEventListener newlistner3=new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String[] rei = new String[10];
                int i = 0;
                if (snapshot.exists())
                {
                    for (DataSnapshot d : snapshot.getChildren())
                    {
                        rei[i] = (String) d.getValue();
                        t2[i].setText(rei[i]);
                        i++;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        };

        ref1.addValueEventListener(newlistner1);
        ref2.addValueEventListener(newlistner2);
        ref3.addValueEventListener(newlistner3);


        SharedPreferences sharedPreferences = getSharedPreferences("New_Shared_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        A="y";
        B="z";
        C="D";
        for(int k=0;k<10;k++)
        {
            int finalK = k;
            imagbut[k].setOnClickListener(new View.OnClickListener()
            {
                boolean isClicked = false;
                @Override
                public void onClick(View view)
                {

                    if (!isClicked)
                    {

                        //editor.putString(n, newHighScore);
                        //esitor.p(R.string.preference_file_key()
                        editor.putString(A, t1[finalK].getText().toString());
                        editor.putString(B, t2[finalK].getText().toString());
                        editor.putString(C, I3[finalK].toString());
                        editor.apply();
                        A = A.concat("y");
                        B = B.concat("z");
                        C = C.concat("D");
                        isClicked = true;
                    }
                    Toast.makeText(beverages.this, "Item add successfully to the cart", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

}
