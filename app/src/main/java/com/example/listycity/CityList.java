package com.example.listycity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of cities
 */

public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void addCities(City city){
        if(cities.contains(city)){
            throw new RuntimeException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */

    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns whether or not a city exists in the list
     * @return
     * Return true or false if we have the city in the list or not
     */

    public int hasCity(City city){
        if(!cities.contains(city)){
            throw new RuntimeException();
        }
        cities.remove(city);


        return cities.size();
    }




}
