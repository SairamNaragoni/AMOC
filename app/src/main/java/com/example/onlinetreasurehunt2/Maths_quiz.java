package com.example.onlinetreasurehunt2;

import android.app.Application;

import com.firebase.client.Firebase;


/**
 * Created by H.P on 26-03-2017.
 */

public class Maths_quiz extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}