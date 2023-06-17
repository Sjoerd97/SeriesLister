package com.example.serieslister;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.serieslister.seurity.Biometrics;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    public ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.main_layout);
        Biometrics.fingerprintScan(constraintLayout, getApplicationContext(), this);

        Toast.makeText(this, "May thee be happy", Toast.LENGTH_LONG).show();
        constraintLayout.setVisibility(View.VISIBLE);
    }
}