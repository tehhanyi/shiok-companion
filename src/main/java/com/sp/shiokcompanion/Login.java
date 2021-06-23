package com.sp.shiokcompanion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Login extends AppCompatActivity {
    MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        song = MediaPlayer.create(Login.this, R.raw.scannric); //the song is door.mp3
        song.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult.getContents()!=null){
            song = MediaPlayer.create(Login.this, R.raw.scan); //the song is door.mp3
            song.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
            builder.setTitle("User's NRIC");
            builder.setMessage(intentResult.getContents() + "\n\n Signed in, Welcome!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                    startActivity(new Intent(Login.this, Setup.class));
                }
            });
            builder.show();
        }
    }

    public void gotosetup (android.view.View View){
        IntentIntegrator intentIntegrator = new IntentIntegrator(Login.this);
        intentIntegrator.setPrompt("Click Volume Up Key for Flash");
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);
        intentIntegrator.initiateScan();
    }
}