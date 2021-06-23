package com.sp.shiokcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class ProfilePage extends AppCompatActivity {
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(ProfilePage.this, R.raw.profile);
        sound.start();
    }

    public void setupnow(View view) {
        startActivity(new Intent(ProfilePage.this, Setup.class));
        finish();
    }

    public void reward(View view) { setContentView(R.layout.rewards); }

    public void mainpage (View view) { startActivity(new Intent(ProfilePage.this, MainPage.class)); }
}