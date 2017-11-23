package com.josethen.coinhood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.robinhood.spark.SparkAdapter;
import com.robinhood.spark.SparkView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private DataAdapter adapter;
    private TextView scrubInfoTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SparkView sparkView =  findViewById(R.id.sparkview);
        scrubInfoTextView = findViewById(R.id.numberTextView);

        adapter = new DataAdapter();
        sparkView.setAdapter(adapter);
        sparkView.setScrubListener(new SparkView.OnScrubListener() {
            @Override
            public void onScrubbed(Object value) {
                if (value == null) {
                    scrubInfoTextView.setText(R.string.scrub_empty);
                } else {
                    scrubInfoTextView.setText(getString(R.string.scrub_format, value));
                }
            }
        });

        View button = findViewById(R.id.random_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.randomize();
            }
        });

//        scrubInfoTextView = (TextView) findViewById(R.id.scrub_info_textview);

    }









}

