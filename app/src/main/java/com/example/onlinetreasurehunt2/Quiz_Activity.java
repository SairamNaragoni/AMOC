package com.example.onlinetreasurehunt2;

<<<<<<< HEAD
import android.app.ProgressDialog;
=======
>>>>>>> origin/master
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinetreasurehunt2.MapsActivity;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
<<<<<<< HEAD
import com.firebase.client.FirebaseApp;
=======
>>>>>>> origin/master
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.snapshot.DoubleNode;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.PublicKey;
<<<<<<< HEAD
import java.util.Timer;
import java.util.TimerTask;

import static com.example.onlinetreasurehunt2.R.id.score_text;
=======
>>>>>>> origin/master


public class Quiz_Activity extends AppCompatActivity implements ValueEventListener {

    public TextView mScoreView;
    public TextView mQuestion;
<<<<<<< HEAD
    public static int m = 0;
=======
>>>>>>> origin/master


    public Double latitude, longitude;
    public LatLng fromPosition;
    public Button mButtonChoice1,mButtonChoice2,mButtonChoice3,mButtonChoice4,mButtonQuit;

<<<<<<< HEAD
    public static int mQuestionNumber=0;
    public static int mScore=1000;
    public String mAnswer;

    public Firebase mQuestionRef;
    public Firebase mchoice1Ref;
    public Firebase mchoice2Ref;
    public Firebase mchoice3Ref;
    public Firebase mchoice4Ref;
    public Firebase mAnswerRef;
    public Firebase mLat;
    public Firebase mlong;
=======
    public static int mQuestionNumber= 0;
    public int mScore=0;
    public String mAnswer;

    public Firebase mQuestionRef,mchoice1Ref,mchoice2Ref,mchoice3Ref,mchoice4Ref,mAnswerRef,mLat,mlong;
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_quiz);


<<<<<<< HEAD

=======
>>>>>>> origin/master
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestion = (TextView) findViewById(R.id.question);

        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mButtonQuit = (Button) findViewById(R.id.quit);

        longitude = 0.0;
        latitude = 0.0;
<<<<<<< HEAD
        updateQuestion();
        loadScore();
        //loadScore();
        if (m==0) {
            final ProgressDialog progressDialog = ProgressDialog.show(this, "Getting Questions from firebase....", "Please wait....", true);
            progressDialog.setCancelable(false);
            progressDialog.show();

            long delayInMillis = 11000;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            }, delayInMillis);
        }else {

        }



=======

        updateQuestion();
>>>>>>> origin/master

        //button1


        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText().equals(mAnswer)){
<<<<<<< HEAD
                    mScore = mScore + 100;
                    updateScore(mScore);
                    loadScore();
                    map();
                    m++;

                    // updateQuestion();
=======
                    mScore = mScore + 1;
                    updateScore(mScore);
                    map();
                   // updateQuestion();
>>>>>>> origin/master

                    Toast.makeText(Quiz_Activity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(Quiz_Activity.this, "wrong", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                    mScore = mScore - 50;
                    loadScore();
=======
>>>>>>> origin/master
                    //updateQuestion();
                }
            }
        });
        //button1

        //button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice2.getText().equals(mAnswer)){
<<<<<<< HEAD
                    mScore = mScore + 100;
                    updateScore(mScore);
                    map();
                    loadScore();
                    m++;

=======
                    mScore = mScore + 1;
                    updateScore(mScore);
                    map();
>>>>>>> origin/master
                    //updateQuestion();
                    Toast.makeText(Quiz_Activity.this, "correct", Toast.LENGTH_SHORT).show();
                }else {
                    //updateQuestion();
                    Toast.makeText(Quiz_Activity.this, "wrong", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                    mScore = mScore - 50;
                    loadScore();
=======
>>>>>>> origin/master
                }
            }
        });
        //button2

        //button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice3.getText().equals(mAnswer)){
<<<<<<< HEAD
                    mScore = mScore + 100;
                    updateScore(mScore);
                    map();
                    loadScore();
                    m++;

=======
                    mScore = mScore + 1;
                    updateScore(mScore);
                    map();
>>>>>>> origin/master
                    //updateQuestion();
                    Toast.makeText(Quiz_Activity.this, "correct", Toast.LENGTH_SHORT).show();
                }else {
                    //updateQuestion();
                    Toast.makeText(Quiz_Activity.this, "wrong", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                    mScore = mScore - 50;
                    loadScore();
=======
>>>>>>> origin/master
                }
            }
        });
        //button3

        //button4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice4.getText().equals(mAnswer)){
<<<<<<< HEAD
                    mScore = mScore + 100;
                    updateScore(mScore);
                    map();
                    m++;
                    loadScore();

=======
                    mScore = mScore + 1;
                    updateScore(mScore);
                    map();
>>>>>>> origin/master
                    //updateQuestion();
                    Toast.makeText(Quiz_Activity.this, "correct", Toast.LENGTH_SHORT).show();
                }else {
                    //updateQuestion();
                    Toast.makeText(Quiz_Activity.this, "wrong", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                    mScore = mScore - 50;
                    loadScore();
=======
>>>>>>> origin/master
                }
            }
        });
        //button4

        //quitButton
        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Quiz_Activity.this,GameOver.class);
                startActivity(i);
            }
        });


    }

<<<<<<< HEAD
    private void loadScore() {
        mScoreView.setText(Integer.toString(mScore));
    }


=======
>>>>>>> origin/master
    private void updateScore(int score){
        mScoreView.setText("" + mScore);
    }

    public void map() {

<<<<<<< HEAD
        mQuestionNumber--;
=======
>>>>>>> origin/master
        mLat = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/latitutde");
        mLat.addValueEventListener(this);



        mlong = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/longitude");
        mlong.addValueEventListener(this);

        //Toast.makeText(Quiz_Activity.this,latitude+", "+ longitude , Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion(){

        mQuestionRef = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/questions");

        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question =dataSnapshot.getValue(String.class);
                mQuestion.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice1Ref = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/choice1");
        mchoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice2Ref = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/choice2");
        mchoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice3Ref = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/choice3");
        mchoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice4Ref = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/choice4");
        mchoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnswerRef = new Firebase("https://onlinetreasurehunt2.firebaseio.com/Quiz_Questions/"+ mQuestionNumber +"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQuestionNumber++;


    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
<<<<<<< HEAD
        //Toast.makeText(this, "Ondatachange", Toast.LENGTH_SHORT).show();
        if (dataSnapshot.getValue() != null) {

           // Toast.makeText(this, "datasnapshot", Toast.LENGTH_SHORT).show();
=======
        if (dataSnapshot.getValue() != null) {
>>>>>>> origin/master
            switch (dataSnapshot.getKey()) {
                case "latitutde":
                    latitude = Double.parseDouble(dataSnapshot.getValue().toString());
                    break;
                case "longitude":
                    longitude = Double.parseDouble(dataSnapshot.getValue().toString());
                    break;
            }
            //Toast.makeText(Quiz_Activity.this,latitude+", "+ longitude , Toast.LENGTH_SHORT).show();
            fromPosition = new LatLng(latitude,longitude);

            if (latitude != 0.0 && longitude != 0.0) {
<<<<<<< HEAD
              //  Toast.makeText(this, "if part", Toast.LENGTH_SHORT).show();
                startMapActivity();
            }
            else {
              //  Toast.makeText(this, "else part", Toast.LENGTH_SHORT).show();
            }
=======
                startMapActivity();
            }
>>>>>>> origin/master
        }
    }

    private void startMapActivity() {
        Bundle args = new Bundle();
<<<<<<< HEAD
       // Toast.makeText(this, "try this", Toast.LENGTH_SHORT).show();
=======
>>>>>>> origin/master
        args.putParcelable("longLat_dataProvider", fromPosition);

        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtras(args);
        startActivity(i);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
