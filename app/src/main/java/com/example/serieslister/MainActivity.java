package com.example.serieslister;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

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

        //Biometrics.fingerprintScan(constraintLayout, getApplicationContext(), this);
        //Toast.makeText(this, "May thee be happy", Toast.LENGTH_LONG).show();

        constraintLayout.setVisibility(View.VISIBLE);

        viewable();
        listAddable();

    }

    private void listAddable() {
        FloatingActionButton fab = findViewById(R.id.fab);
        EditText editText = (EditText) findViewById(R.id.et_series);

        fab.setOnClickListener(v -> {
            editText.setVisibility(View.VISIBLE);
            editText.showContextMenu();
            series = Arrays.copyOf(series, series.length + 1);
            editText.setOnClickListener(v1 -> series[series.length - 1] = editText.getText().toString());

        });

        Toast.makeText(this, "Series added", Toast.LENGTH_LONG).show();
        editText.setVisibility(View.GONE);
    }

    private void viewable() {
        listView = (ListView) findViewById(R.id.seriesListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), series, seriesImages);
        listView.setAdapter(customBaseAdapter);
    }
}