package com.sp.shiokcompanion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ShiokMap extends FragmentActivity implements OnMapReadyCallback {

    private MediaPlayer sound;
    private GoogleMap mMap;
    private GPSTracker gpsTracker;
    private double latitude = 0.0d;
    private double longitude = 0.0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiok_map);
        //gpsTracker.checkGPSPermissions();
        gpsTracker = new GPSTracker(ShiokMap.this);
        gpsTracker.canGetLocation();
        if (gpsTracker.canGetLocation()) {
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please check your internet connection!", Toast.LENGTH_LONG).show();
            gpsTracker.canGetLocation();
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void mainpage (View view) {
        startActivity(new Intent(ShiokMap.this, MainPage.class));
        finish();
    }
    public void rewards (View view) {
        startActivity(new Intent(ShiokMap.this, ProfilePage.class));
        finish();
    }
    public void clickspot(View view)
    {
        IntentIntegrator intentIntegrator = new IntentIntegrator(ShiokMap.this);
        intentIntegrator.setPrompt("Click Volume Up Key for Flash");
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);
        intentIntegrator.initiateScan();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        gpsTracker.stopUsingGPS();
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
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng clementi = new LatLng(1.3189, 103.7681);
        LatLng macdonald = new LatLng(1.310247, 103.778530);
        LatLng starbuck = new LatLng(1.309686, 103.776921);
        LatLng track = new LatLng(1.310053, 103.775676);
        LatLng hilltop = new LatLng(1.3112378,103.7743698);
        LatLng me = new LatLng(latitude, longitude);
        Marker shiok = mMap.addMarker(new MarkerOptions().position(clementi).title("Mahjong")
                .snippet("Clementi CC")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.shiokspot)));
        Marker shiok1 = mMap.addMarker(new MarkerOptions().position(macdonald).title("Chess")
                .snippet("Spectrum @ SP, Near Macdonald")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.shiokspot)));
        Marker shiok2 = mMap.addMarker(new MarkerOptions().position(starbuck).title("Cooking")
                .snippet("Starbucks @ SP")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.shiokspot)));
        Marker shiok3 = mMap.addMarker(new MarkerOptions().position(track).title("TaiChi")
                .snippet("SP Track Stadium")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.shiokspot)));
        Marker shiok4 = mMap.addMarker(new MarkerOptions().position(hilltop).title("Movies")
                .snippet("HillTop @ SP")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.shiokspot)));
        Marker ME = mMap.addMarker(new MarkerOptions().position(me).title("My Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(me, 18));
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult.getContents()!=null){
            sound = MediaPlayer.create(ShiokMap.this, R.raw.scan);
            sound.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(ShiokMap.this);
            builder.setTitle("Activity Done");
            builder.setMessage(intentResult.getContents() + "\n\nCome Back Again! :)");
            builder.setPositiveButton("Claim Points", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
    }
}