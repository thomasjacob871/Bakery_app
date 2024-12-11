package com.example.sucre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText sgnemail, sgnpass;
    private Button sgnbtn;
    private TextView loginredirecttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        auth = FirebaseAuth.getInstance();
        sgnemail = findViewById(R.id.username);
        sgnpass = findViewById(R.id.password);
        sgnbtn = findViewById(R.id.sgnup);
        loginredirecttext = findViewById(R.id.loginredirecttext);

        loginredirecttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        sgnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = sgnemail.getText().toString().trim();
                String password = sgnpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    sgnemail.setError("Email cannot be empty");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    sgnpass.setError("Password cannot be empty");
                    return;
                }

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    sendVerificationEmail();
                                    Toast.makeText(MainActivity2.this, "Signup successful. Verification email sent.", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity2.this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity2.this, "Signup failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity2.this, "Verification email sent", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity2.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
