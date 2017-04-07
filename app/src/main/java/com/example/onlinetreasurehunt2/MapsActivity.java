package com.example.onlinetreasurehunt2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static GoogleMap mMap;
    public TextView mapTimer;
    private float mapZoomLevel;
    LatLng defaultLoc , ll;



    public void scanQR(View view){

        Intent i = new Intent(getApplicationContext(),ReaderActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    LocationManager locationManager;
    LocationListener locationListener;
    Location location;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapTimer = (TextView)findViewById(R.id.mapTimer);
        new CountDownTimer(180000,1000){


            @Override
            public void onTick(long millisUntilFinished) {

                mapTimer.setText(Integer.toString(MainActivity.timeRemaining));
            }

            @Override
            public void onFinish() {

            }
        }.start();
        mMap.getUiSettings().setZoomControlsEnabled(true);

        Intent i = getIntent();
        ll = i.getParcelableExtra("longLat_dataProvider");
       // Toast.makeText(this,Double.toString(ll.latitude) + Double.toString(ll.longitude) + "sfdgfhgjhjk", Toast.LENGTH_SHORT).show();

        if (i != null && ll != null) {


            defaultLoc = new LatLng(ll.latitude, ll.longitude);
            mMap.addMarker(new MarkerOptions().position(defaultLoc).title("come here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
           // Toast.makeText(this, Double.toString(ll.latitude), Toast.LENGTH_SHORT).show();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLoc, 15));


        }



        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));

                mMap.addMarker(new MarkerOptions().position(defaultLoc).title("come here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLoc, 15));




                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                    if(listAddresses!=null && listAddresses.size()>0){

                        Log.i("Info",listAddresses.get(0).toString());
                        String address = "";

                        if(listAddresses.get(0).getSubThoroughfare()!=null)
                        {
                            address+=listAddresses.get(0).getSubThoroughfare()+" ";
                        }
                        if(listAddresses.get(0).getThoroughfare()!=null)
                        {
                            address+=listAddresses.get(0).getThoroughfare()+", ";
                        }
                        if(listAddresses.get(0).getLocality()!=null)
                        {
                            address+=listAddresses.get(0).getLocality()+", ";
                        }
                        if(listAddresses.get(0).getPostalCode()!=null)
                        {
                            address+=listAddresses.get(0).getPostalCode()+", ";
                        }
                        if(listAddresses.get(0).getCountryName()!=null)
                        {
                            address+=listAddresses.get(0).getCountryName()+" ";
                        }


                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if(Build.VERSION.SDK_INT<23){

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);

        }
        else{

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }
            else
            {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);



                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if(lastKnownLocation!=null) {
                    LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
                }
                else
                {
                  //  Toast.makeText(MapsActivity.this, "obtaining Location", Toast.LENGTH_SHORT).show();
                    LatLng svnit1 = new LatLng(21.167670, 72.785091);
                    //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    mMap.addMarker(new MarkerOptions().position(svnit1).title("SVNIT").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(svnit1,2));
                }
            }
        }



    }
}
