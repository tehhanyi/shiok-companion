package com.sp.shiokcompanion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(MainPage.this, R.raw.welcome);
        sound.start();
    }

    public void gotospot1 (View View)
    {
        setContentView(R.layout.shiokspots);
    }
    public void gotospot2 (View View)
    {
        setContentView(R.layout.shiokspots2);
    }
    public void gotospot3 (View View)
    {
        setContentView(R.layout.shiokspots3);
    }
    public void gotoshiokspot (View View) { startActivity(new Intent(MainPage.this, ShiokMap.class)); }
    public void gotodoc1 (View View)
    {
        setContentView(R.layout.shiokdoc1);
    }
    public void gotodoc2 (View View)
    {
        setContentView(R.layout.shiokdoc2);
    }
    public void gotodoc3 (View View)
    {
        setContentView(R.layout.shiokdoc3);
    }
    public void gotodoc4 (View View) { setContentView(R.layout.shiokdoc4); }
    public void gotodoc5 (View View)
    {
        setContentView(R.layout.shiokdoc5);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(MainPage.this, R.raw.ok);
        sound.start();
    }
    public void gotodoc6 (View View){ setContentView(R.layout.shiokdoc6);}
    public void gotoshiokdoc (View View)
    {
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(MainPage.this, R.raw.doc);
        sound.start();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
        builder.setTitle("Confirm Call Doctor?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                sound = MediaPlayer.create(MainPage.this, R.raw.phone); //the song is door.mp3
                sound.start();
                startActivity(new Intent(MainPage.this, shiokdoc.class));
            }
        });
        builder.show();
    }

    public void gotoshiokpost(View View) { startActivity(new Intent(MainPage.this, shiokpost.class)); }
    public void speech(View View)
    {
        Toast.makeText(getApplicationContext(),"Text-to-Speech Mode",Toast.LENGTH_LONG).show();
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(MainPage.this, R.raw.help);
        sound.start();
    }

    public void help(View View)
    {
        startActivity(new Intent("android.intent.action.VIEW",
                Uri.parse("https://drive.google.com/file/d/1V71sO0jPFlvHgi-l2lWZbEk3O5d7M0TV/view?usp=sharing")));//Put User Manual here
    }

    public void slientmode (View view)
    {
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
            }
        }
        Toast.makeText(getApplicationContext(),"Slient Mode ON",Toast.LENGTH_SHORT).show();
    }

    public void profile(View View) { startActivity(new Intent(MainPage.this, ProfilePage.class)); finish(); }
    public void mainpage (View view) { setContentView(R.layout.main_page); }
}