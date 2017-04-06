package com.example.onlinetreasurehunt2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
    static EditText teamname;
    static String team = null;
    Button submit;
    private FirebaseAuth firebaseAuth;
   // public  String user_id = firebaseAuth.getCurrentUser().getUid();

    DatabaseReference databaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailProfile = (TextView) findViewById(R.id.emailProfile);
        Intent i = getIntent();
        String name= i.getStringExtra("name");
        emailProfile.setText(name);

        member1 = (EditText) findViewById(R.id.member1);
        member2 = (EditText) findViewById(R.id.member2);
        member3 = (EditText) findViewById(R.id.member3);
        member4 = (EditText) findViewById(R.id.member4);
        teamname= (EditText) findViewById(R.id.teamname);

        submit = (Button) findViewById(R.id.submit);

        databaseData = FirebaseDatabase.getInstance().getReference("users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean q = false;
                q = addData();

                if (q) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(ProfileActivity.this, "Enter the name of all members", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean addData() {

        Intent i = getIntent();
        String mobileNo= i.getStringExtra("mobileNo");

        int flag=0;
        team= teamname.getText().toString().trim();
        if (!TextUtils.isEmpty(team)){

            String id=databaseData.push().getKey();
            //Data msg = new Data(id,team);
           // databaseData.child("details").push().setValue(msg);
            Toast.makeText(this, "Data added team", Toast.LENGTH_SHORT).show();
            flag++;
        }else{
            Toast.makeText(this, "enter name team", Toast.LENGTH_SHORT).show();
        }


        String m1= member1.getText().toString().trim();
        if (!TextUtils.isEmpty(m1)){

            String id1=databaseData.push().getKey();
            Data msg = new Data(id1,m1);
            databaseData.child(mobileNo).child(team).child("member1").setValue(m1);
            Toast.makeText(this, "Data added1", Toast.LENGTH_SHORT).show();
            flag++;
        }else{
            Toast.makeText(this, "enter name1", Toast.LENGTH_SHORT).show();
        }

        String m2= member2.getText().toString().trim();
        if (!TextUtils.isEmpty(m2)){

            String id2=databaseData.push().getKey();
            Data msg = new Data(id2,m2);
            databaseData.child(mobileNo).child(team).child("member2").setValue(m2);
            Toast.makeText(this, "Data added2", Toast.LENGTH_SHORT).show();
            flag++;
        }else{
            Toast.makeText(this, "enter name2", Toast.LENGTH_SHORT).show();
        }

        String m3= member3.getText().toString().trim();
        if (!TextUtils.isEmpty(m3)){

            String id=databaseData.push().getKey();
            Data msg = new Data(id,m3);
            databaseData.child(mobileNo).child(team).child("member3").setValue(m3);
            Toast.makeText(this, "Data added3", Toast.LENGTH_SHORT).show();
            flag++;
        }else{
            Toast.makeText(this, "enter name3", Toast.LENGTH_SHORT).show();
        }

        String m4= member4.getText().toString().trim();
        if (!TextUtils.isEmpty(m4)){

            String id=databaseData.push().getKey();
            Data msg = new Data(id,m4);
            databaseData.child(mobileNo).child(team).child("member4").setValue(m4);
            Toast.makeText(this, "Data added4", Toast.LENGTH_SHORT).show();
            flag++;
        }else{
            Toast.makeText(this, "enter name4", Toast.LENGTH_SHORT).show();
        }


        if (flag==5){
            return true;
        }else {
            return false;
        }

    }
}

