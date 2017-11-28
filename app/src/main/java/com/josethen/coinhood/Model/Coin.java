package com.josethen.coinhood.Model;

public class Coin {

    private String coin;        // Coin acyonrm



    private String base;        // Coin name or institution

    public Coin(String coin, String base){
        this.coin = coin;
        this.base = base;
    }


    public String getCoin(){
        return this.coin;
    }

    public String getBase() {
        return base;
    }

}
