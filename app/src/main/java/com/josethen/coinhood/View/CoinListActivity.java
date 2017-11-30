package com.josethen.coinhood.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.josethen.coinhood.Model.Coin;
import com.josethen.coinhood.Model.CustomAdapter;
import com.josethen.coinhood.R;

import java.util.ArrayList;

public class CoinListActivity extends AppCompatActivity {

//    Checkers checking = new Checkers();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_list);

        ListView coinListView = findViewById(R.id.listOfCoins);

        //creating the adapter object
        CustomAdapter adapter = new CustomAdapter(this, generateCoinsList());

        // Set custom adapter as adapter to the custom list view
        coinListView.setAdapter(adapter);


        coinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent charts = new Intent(CoinListActivity.this, ExchangeTabs.class);
                startActivity(charts);
            }
        });

    }


    /**
     * Util function to generate list of items
     *
     * @return ArrayList
     */
    private ArrayList<Coin> generateCoinsList() {
        String coin[] = getResources().getStringArray(R.array.coinAcronym);
        String base[] = getResources().getStringArray(R.array.base);

        ArrayList<Coin> list = new ArrayList<>();

        for (int i = 0; i < coin.length; i++) {
            list.add(new Coin(coin[i], base[i]));
        }

        return list;
    }
}
