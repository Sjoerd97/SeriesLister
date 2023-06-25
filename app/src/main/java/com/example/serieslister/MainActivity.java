package com.example.serieslister;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> series = new ArrayList<>();
    int seriesImages[] = {R.drawable.sopranos, R.drawable.the_wire};

    public ConstraintLayout constraintLayout;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.main_layout);
        series.add("Sopranos");
        series.add("The Wire");

        // Disabled for quick testing purposes
        //Biometrics.fingerprintScan(constraintLayout, getApplicationContext(), this);
        //Toast.makeText(this, "May thee be happy", Toast.LENGTH_LONG).show();

        constraintLayout.setVisibility(View.VISIBLE);

        viewable();
        listAddable();

    }

    private void listAddable() {
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v -> showAddSeries());
}

    private void showAddSeries() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.add_series, null);

        EditText editText = (EditText) dialogLayout.findViewById(R.id.et_series);

        alertDialogBuilder.setTitle("Add Series")
                .setPositiveButton("SAVE", (dialog, which) -> {
                    series.add(editText.getText().toString());
                    Toast.makeText(this, "Series added", Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("CANCEL", (dialog, which) -> {
                    Toast.makeText(this, "Jammur", Toast.LENGTH_SHORT).show();
                })
                .setView(dialogLayout)
                .show();
    }

    private void viewable() {
        listView = (ListView) findViewById(R.id.seriesListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), series, seriesImages);
        listView.setAdapter(customBaseAdapter);
    }
}