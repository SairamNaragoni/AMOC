package com.example.onlinetreasurehunt2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by H.P on 15-03-2017.
 */
public class Register extends AppCompatActivity {

    private EditText emailRegister;
    private EditText passwordRegister;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        emailRegister = (EditText) findViewById(R.id.emailRegister);
        passwordRegister = (EditText) findViewById(R.id.passwordRegister);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public  void Register_onclick_user(View view){
        final ProgressDialog progressDialog = ProgressDialog.show(Register.this,"Please wait....","Processing....",true);
        (firebaseAuth.createUserWithEmailAndPassword(emailRegister.getText().toString() , passwordRegister.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Registration sucessful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Register.this, Login.class);
                            startActivity(i);
                        }
                        else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}