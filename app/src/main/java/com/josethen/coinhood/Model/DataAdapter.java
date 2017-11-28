package com.josethen.coinhood.Model;

import com.robinhood.spark.SparkAdapter;

import java.util.Random;



public class DataAdapter extends SparkAdapter {
    private final float[] yData;
    private final Random random;

    public DataAdapter() {
        random = new Random();
        yData = new float[50];
        randomize();
    }

    public void randomize() {
        for (int i = 0, count = yData.length; i < count; i++) {
            yData[i] = random.nextFloat();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return yData.length;
    }

    @Override
    public Object getItem(int index) {
        return yData[index];
    }

    @Override
    public float getY(int index) {
        return yData[index];
    }
}