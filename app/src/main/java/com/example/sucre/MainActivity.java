package com.example.sucre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sucre.frag.home;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{
    private FirebaseAuth auth;
    private EditText logem,logpas;

    private Button Logbtn;
    private Button sgnUp;
    private TextView frgtpass;

    GoogleSignInOptions google;
    GoogleSignInClient google1;
    ImageView googbtn;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth=FirebaseAuth.getInstance();
        logem=findViewById(R.id.username1);
        logpas=findViewById(R.id.password1);
        Logbtn=findViewById(R.id.lgnbtn);
        sgnUp=findViewById(R.id.sgnbtn);
        SharedPreferences sharedPreferences =getSharedPreferences(
                "New_Shared_pref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Logbtn.setOnClickListener(new View.OnClickListener()
        {
                                      @Override
                                      public void onClick(View view)
                                      {
                                          String email = logem.getText().toString();
                                          String pass = logpas.getText().toString();

                                          if (email.isEmpty())
                                          {
                                              logem.setError("Email cannot be empty");
                                              return;
                                          } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                                          {
                                              logem.setError("Please enter a valid email");
                                              return;
                                          }

                                          if (pass.isEmpty())
                                          {
                                              logpas.setError("Password cannot be empty");
                                              return;
                                          }

                                          auth.signInWithEmailAndPassword(email, pass)
                                                  .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
                                                  {
                                                      @Override
                                                      public void onComplete(@NonNull Task<AuthResult> task)
                                                      {
                                                          //Log.d("TAG", "signInWithEmail:onComplete:" + task.isSuccessful());

                                                          // If sign in fails, display a message to the user. If sign in succeeds
                                                          // the auth state listener will be notified and logic to handle the
                                                          // signed in user can be handled in the listener.
                                                          if (!task.isSuccessful())
                                                          {
                                                              Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                                                              //Toast.makeText, "", Toast.LENGTH_SHORT).show();
                                                              //Log.w("TAG", "signInWithEmail:failed", task.getException());

                                                          } else
                                                          {
                                                              checkIfEmailVerified();
                                                          }
                                                          // ...
                                                      }
                                                  });

                                      }
            private void checkIfEmailVerified()
            {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null)
                {
                    if (user.isEmailVerified())
                    {
                        // user is verified, so you can finish this activity or send user to activity which you want.
                        //finish();
                        Toast.makeText(MainActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MainActivity3.class));

                    } else
                    {
                        // email is not verified, so just prompt the message to the user and restart this activity.
                        // NOTE: don't forget to log out the user.
                        Toast.makeText(MainActivity.this, "Email wasn't verified", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        //restart this activity

                    }
                }
            }

        });


        sgnUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

        Log.i("State","onCreate");



        frgtpass=findViewById(R.id.frgtpas);

        frgtpass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,forgot.class));

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
