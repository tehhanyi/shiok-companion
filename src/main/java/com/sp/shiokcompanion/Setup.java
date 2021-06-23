package com.sp.shiokcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setup extends AppCompatActivity {
    MediaPlayer sound;
    Button lang;
    Button font;
    Button interest;
    Button others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup1);
        sound = MediaPlayer.create(Setup.this, R.raw.setup);
        sound.start();
    }

    public void setupnow (View View)
    {
        setContentView(R.layout.setup2);// set language
        sound = MediaPlayer.create(Setup.this, R.raw.picklanguage);
        sound.start();
    }


    public void selectedeng(View view)
    {
        lang = findViewById(R.id.button3);
        lang.setVisibility(View.VISIBLE);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(Setup.this, R.raw.english);
        sound.start();
    }

    public void selectedchi(View view)
    {
        lang = findViewById(R.id.button3);
        lang.setVisibility(View.VISIBLE);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(Setup.this, R.raw.chinese);
        sound.start();
    }
    public void selectedmal(View view)
    {
        lang = findViewById(R.id.button3);
        lang.setVisibility(View.VISIBLE);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(Setup.this, R.raw.malay);
        sound.start();
    }
    public void selectedtam(View view)
    {
        lang = findViewById(R.id.button3);
        lang.setVisibility(View.VISIBLE);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(Setup.this, R.raw.tamil);
        sound.start();
    }
    public void setfont (View View)
    {
        setContentView(R.layout.setup3);
        sound = MediaPlayer.create(Setup.this, R.raw.pickfont);
        sound.start();
    }
    public void selectedfont (View view)
    {
        font = findViewById(R.id.button11);
        if(sound !=null){
            if(sound.isPlaying()){
                sound.stop();
                sound.release();
            }
        }
        sound = MediaPlayer.create(Setup.this, R.raw.ok);
        sound.start();
        font.setVisibility(View.VISIBLE);
    }
    public void selectedinterest(View view)
    {
        interest = findViewById(R.id.button12);
        interest.setVisibility(View.VISIBLE);
    }

    public void other(View view)
    {
        interest = findViewById(R.id.button12);
        others = findViewById(R.id.others);
        others.setText("   Others: \n   Drawing \n   Stitching\n   Sewing\n   Movies\n   Cooking");
        interest.setVisibility(View.VISIBLE);
    }

    public void setinterest (View View)
    {
        setContentView(R.layout.setup4);
        sound = MediaPlayer.create(Setup.this, R.raw.pickinterests);
        sound.start();
    }


    public void setuplater (View View)
    {
        startActivity(new Intent(Setup.this, MainPage.class));
        finish();
    }


}