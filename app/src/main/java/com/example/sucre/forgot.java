package com.example.sucre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot extends AppCompatActivity
{

    private TextView Loginredirecttext;
    private EditText txtemail;
    private String Email;
    private FirebaseAuth auth;
    private Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);


        Loginredirecttext = findViewById(R.id.loginredirecttext);

        Loginredirecttext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(forgot.this, MainActivity.class));
            }
        });


        auth=FirebaseAuth.getInstance();
        txtemail=findViewById(R.id.email);
        Submit=findViewById(R.id.submit);

        Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                validatedata();

            }
        });
    }

    private void validatedata()
    {
        Email=txtemail.getText().toString();
        if (Email.isEmpty())
        {
            txtemail.setError("Email required");
        }
        else
        {
            forgotpass();
        }

    }
    private void forgotpass()
    {
        auth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>()
        {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(forgot.this, "Check your email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(forgot.this, MainActivity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(forgot.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}