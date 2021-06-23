package com.sp.shiokcompanion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.WindowManager;

//import com.google.firebase.auth.FirebaseAuth;

//import com.sp.shiokcompanion.Constant;

public class Start extends AppCompatActivity {

    MediaPlayer song;
    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        //mAuth = FirebaseAuth.getInstance();
        song = MediaPlayer.create(Start.this, R.raw.shiok); //the song is door.mp3
        song.start();
        //Constant.allRequestsArray.clear();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Animation anim = AnimationUtils.loadAnimation(this, R.anim.side_slide);
        //logo.setAnimation(anim);
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                        startActivity(new Intent(Start.this, Login.class));
                        finish();
                }
            }
        };
        thread.start();
    }
}