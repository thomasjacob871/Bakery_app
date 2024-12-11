package com.example.sucre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Card_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);


        TextView username=(TextView) findViewById(R.id.username1);
        TextView pass1=(TextView) findViewById(R.id.user);
        TextView pass2=(TextView) findViewById(R.id.user1);


        Button lgnbtn= (Button)  findViewById(R.id.btn);

        lgnbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if((username.getText().toString().equals("8710987124323542")) && (pass1.getText().toString().equals("06/26")) && (pass2.getText().toString().equals("658")))
                {
                    Toast.makeText(Card_details.this, "Payment Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Card_details.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}