package com.example.onlinetreasurehunt2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String PREF_NAME = "LOCA";
    public static final String IS_LOGIN = "is_logged_in";
    public static final String KEY_MOBILE_NUMBER = "user_mobile_number";
    public static final String KEY_NAME = "user_name";

    int PRIVATE_MODE = 0;
    private TextView textName, textMobileNo;
    private NavigationView navigationView;

    private View navHeader;
    public static String q;
    public static int timeRemaining;
    private SharedPreferences mPref;
    static SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navHeader = navigationView.getHeaderView(0);
        textName = (TextView) navHeader.findViewById(R.id.teamProfile);
        textMobileNo = (TextView) navHeader.findViewById(R.id.mobileNo);



        mPref = getApplicationContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();


        String isLoggedIn = mPref.getString(IS_LOGIN, null);



        if (isLoggedIn == null) {
            startActivity(new Intent(this, Authentication.class));
            finish();
        } else {
            //mTextView.setText(mPref.getString(KEY_MOBILE_NUMBER, null));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Developed by ShivaRaju and SandeepVerma", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadNavHeader();



        q=mPref.getString(KEY_MOBILE_NUMBER,null);

    }



    private void loadNavHeader() {
        textName.setText(mPref.getString(KEY_NAME, null));
        textMobileNo.setText(mPref.getString(KEY_MOBILE_NUMBER, null));
    }

    public void timerStart(){

        new CountDownTimer(180000+100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeRemaining = (int) (millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                Intent i= new Intent(getApplicationContext(),GameOver.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Done!!", Toast.LENGTH_SHORT).show();

            }
        }.start();
    }

    public void startGame(View view){


        timerStart();
        Intent i = new Intent(this,Quiz_Activity.class);


        startActivity(i);
    }

    public void qrScanner(View view){

        Intent i = new Intent(this,ReaderActivity.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            mEditor.clear();
            mEditor.commit();
            startActivity(new Intent(MainActivity.this, Authentication.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rules) {

            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
