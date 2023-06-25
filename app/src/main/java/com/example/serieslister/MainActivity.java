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

import com.example.serieslister.domain.Series;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ArrayList<Series> series = new ArrayList<>();
    int[] seriesImages = {R.drawable.sopranos, R.drawable.the_wire};

    public ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.main_layout);
        series.add(new Series.Builder()
                .title("Sopranos")
                .build());
        series.add(new Series.Builder()
                .title("The Wire")
                .build());

        // Disabled for quick testing purposes
        // Biometrics.fingerprintScan(constraintLayout, getApplicationContext(), this);
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

        alertDialogBuilder.setTitle("Voeg je Serie toe")
                .setPositiveButton("SAVE", (dialog, which) -> {
                    series.add(new Series.Builder()
                            .title(editText.getText().toString())
                            .build());
                    Toast.makeText(this, "Serie toegevoegd", Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("CANCEL", (dialog, which) -> {
                    Toast.makeText(this, "Jammur", Toast.LENGTH_SHORT).show();
                })
                .setView(dialogLayout)
                .show();
    }

    private void viewable() {
        ListView listView = (ListView) findViewById(R.id.seriesListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), series, seriesImages);
        listView.setAdapter(customBaseAdapter);
    }
}