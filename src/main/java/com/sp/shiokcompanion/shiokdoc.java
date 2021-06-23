package com.sp.shiokcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class shiokdoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shiokdoc);
    }
    public void mainpage (View view) {
        startActivity(new Intent(shiokdoc.this, MainPage.class));
        finish();
    }
}