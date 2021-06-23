package com.sp.shiokcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class shiokpost extends AppCompatActivity {
MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiokpost);
        song = MediaPlayer.create(shiokpost.this, R.raw.shiokpost);
        song.start();

    }

    public void mainpage (View view) {
        startActivity(new Intent(shiokpost.this, MainPage.class));
        finish();
    }
}