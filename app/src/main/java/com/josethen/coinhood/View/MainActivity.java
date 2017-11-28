package com.josethen.coinhood.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.josethen.coinhood.Helpers.Checkers;
import com.josethen.coinhood.Model.DataAdapter;
import com.josethen.coinhood.R;
import com.robinhood.spark.SparkView;

public class MainActivity extends AppCompatActivity {
    private DataAdapter adapter;
    private TextView scrubInfoTextView;
    private TextView wifiInfoTextView;
    Checkers checking = new Checkers();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wifiInfoTextView = findViewById(R.id.wifi_info_textview);





        boolean isConnected = checking.www(this);
        if (isConnected){
            wifiInfoTextView.setText(R.string.online);
        }
        else{
            wifiInfoTextView.setText(R.string.offline);
        }

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

