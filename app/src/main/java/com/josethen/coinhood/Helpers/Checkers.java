package com.josethen.coinhood.Helpers;


import android.content.ClipData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.josethen.coinhood.Model.Coin;
import com.josethen.coinhood.R;

import java.util.ArrayList;

public class Checkers {

    public boolean www(Context context){

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;

    }

}
