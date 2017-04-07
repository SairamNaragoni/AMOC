package com.example.onlinetreasurehunt2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.onlinetreasurehunt2.MainActivity.KEY_MOBILE_NUMBER;
import static com.example.onlinetreasurehunt2.MainActivity.mEditor;
import static com.example.onlinetreasurehunt2.MainActivity.q;
import static com.example.onlinetreasurehunt2.MainActivity.timeRemaining;


public class GameOver extends AppCompatActivity {

    DatabaseReference databaseData;

    TextView mfinalScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mfinalScore = (TextView) findViewById(R.id.finalScore);

        databaseData = FirebaseDatabase.getInstance().getReference("users");

        mfinalScore.setText(Integer.toString(Quiz_Activity.mScore));

        String ms= mfinalScore.getText().toString().trim();



        databaseData.child(q).child("score").setValue(ms);
        databaseData.child(q).child("time left").setValue(timeRemaining);
    }


    @Override
    public void onBackPressed() {
        // do nothing.
    }


    public void logout(View view){
        mEditor.clear();
        mEditor.commit();
        startActivity(new Intent(GameOver.this, Authentication.class));
        finish();

    }
}
