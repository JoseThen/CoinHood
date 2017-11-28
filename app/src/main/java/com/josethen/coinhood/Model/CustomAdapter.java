package com.josethen.coinhood.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.josethen.coinhood.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context; // context
    private ArrayList<Coin> coins; // data source for the list adapter


    // public constructor
    public CustomAdapter(Context context, ArrayList<Coin> coins) {
        this.context = context;
        this.coins = coins;

    }


    @Override
    public int getCount() {
        return coins.size();
    }

    @Override
    public Object getItem(int position) {
        return coins.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;


        //inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.coin_entry_setup, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        // get current coin to be displayed
        Coin currentCoin = (Coin) getItem(position);




        // set the text for coin and base from the current Coin object
        viewHolder.coin.setText(currentCoin.getCoin());
        viewHolder.base.setText(currentCoin.getBase());

        return view;
    }

    // ViewHolder inner class to replace :
    // TextView tVcoin = view.findViewById(R.id.coin);
    // TextView tVbase = view.findViewById(R.id.coin);
    // This was in the above function

    private class ViewHolder {
        TextView coin;
        TextView base;


        public ViewHolder(View view) {
            coin =  (TextView) view.findViewById(R.id.coin);
            base = (TextView) view.findViewById(R.id.base);
        }
    }

}



