package com.example.serieslister;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.serieslister.seurity.Biometrics;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    String series[] = {"Sopranos", "The Wire"};
    int seriesImages[] = {R.drawable.sopranos, R.drawable.the_wire};

    public ConstraintLayout constraintLayout;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.main_layout);
        Biometrics.fingerprintScan(constraintLayout, getApplicationContext(), this);

        Toast.makeText(this, "May thee be happy", Toast.LENGTH_LONG).show();
        constraintLayout.setVisibility(View.VISIBLE);

        listView = (ListView) findViewById(R.id.seriesListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), series, seriesImages);
        listView.setAdapter(customBaseAdapter);
    }
}