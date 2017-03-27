package com.example.onlinetreasurehunt2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by H.P on 15-03-2017.
 */
public class Login extends AppCompatActivity {

    private EditText emailLogin;
    private EditText passwordLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailLogin = (EditText) findViewById(R.id.emailLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void Login_onclick_user(View view){
        final ProgressDialog progressDialog = ProgressDialog.show(Login.this,"Please wait....","Processing....",true);
        (firebaseAuth.signInWithEmailAndPassword(emailLogin.getText().toString() , passwordLogin.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this,"Login sucessful",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Login.this,ProfileActivity.class);
                            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }
                        else {
                            Log.e("ERROR",task.getException().toString());
                            Toast.makeText(Login.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}