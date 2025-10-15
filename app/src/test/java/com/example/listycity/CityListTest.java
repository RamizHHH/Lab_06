package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.addCities(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }

    @Test
    void addCity(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCities(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCities(city);
        assertThrows(RuntimeException.class, ()->{
           cityList.addCities(city);
        });
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCities(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testRemoveCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Lethbridge", "Alberta");
        cityList.addCities(city);
        assertEquals(2,(cityList.getCities().size()));
        cityList.hasCity(city);
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    void testThrows(){
        CityList cityList = mockCityList();
        City city = new City("Lethbridge", "Alberta");
        cityList.addCities(city);
        assertEquals(2,(cityList.getCities().size()));
        City city1 = new City("Calgary", "Alberta");
        assertThrows(RuntimeException.class, ()->{
            cityList.hasCity(city1);
        });
    }

    @Test
    void testNumber(){
        CityList cityList = mockCityList();
        City city = new City("Lethbridge", "Alberta");
        cityList.addCities(city);
        assertEquals(2,(cityList.getCities().size()));
        cityList.hasCity(city);
        assertEquals(1,(cityList.getCities().size()));
    }

}
