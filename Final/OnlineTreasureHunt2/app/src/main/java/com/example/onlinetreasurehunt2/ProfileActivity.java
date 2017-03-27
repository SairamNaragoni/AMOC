package com.example.onlinetreasurehunt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private TextView emailProfile;


    EditText member1;
    EditText member2;
    EditText member3;
    EditText member4;
    Button submit;
    private FirebaseAuth firebaseAuth;

    DatabaseReference databaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailProfile = (TextView) findViewById(R.id.emailProfile);
        emailProfile.setText(getIntent().getExtras().getString("Email"));

        member1 = (EditText) findViewById(R.id.member1);
        member2 = (EditText) findViewById(R.id.member2);
        member3 = (EditText) findViewById(R.id.member3);
        member4 = (EditText) findViewById(R.id.member4);
        submit = (Button) findViewById(R.id.submit);

        databaseData = FirebaseDatabase.getInstance().getReference("users details");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addData();
            }
        });

    }

    public void addData(){

        String m1 = member1.getText().toString().trim();

        if (!TextUtils.isEmpty(m1)){

            String id = databaseData.push().getKey();

            Data msg = new Data(id,m1);
            databaseData.child(id).setValue(msg);
            Toast.makeText(this,"Data added",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "enter name", Toast.LENGTH_SHORT).show();
        }

        String m2 = member2.getText().toString().trim();

        if (!TextUtils.isEmpty(m2)){

            String id2 = databaseData.push().getKey();

            Data msg = new Data(id2,m2);
            databaseData.child(id2).setValue(msg);
            Toast.makeText(this,"Data added2",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "enter name2", Toast.LENGTH_SHORT).show();
        }

       String m3 = member3.getText().toString().trim();

        if (!TextUtils.isEmpty(m3)){

          String id = databaseData.push().getKey();

           Data msg = new Data(id,m3);
            databaseData.child(id).setValue(msg);
            Toast.makeText(this,"Data added3",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "enter name3", Toast.LENGTH_SHORT).show();
        }

        String m4 = member4.getText().toString().trim();

        if (!TextUtils.isEmpty(m4)){

            String id = databaseData.push().getKey();

            Data msg = new Data(id,m4);
            databaseData.child(id).setValue(msg);
            Toast.makeText(this,"Data added4",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "enter name4", Toast.LENGTH_SHORT).show();
        }
    }
}
