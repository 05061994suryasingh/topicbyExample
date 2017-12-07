package com.chromeinfotech.myfirst.UI.serialization;

import java.io.Serializable;

/**
 * Country class which implement the Serializable
 */

public class Country implements Serializable {

    private  String name;
    private String capital;
    private int population;
    private String TAG = this.getClass().getSimpleName();

    public Country(String name,String capital,int population){
        this.name       = name;
        this.capital    = capital;
        this.population = population;
    }

    public Country(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public int getpopulation() {
        return population;
    }

    public void setpopulation(int population) {
        this.population = population;
    }


}
