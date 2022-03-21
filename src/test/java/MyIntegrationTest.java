//package com.napier.sem;
import com.napier.sem.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyIntegrationTest
{
    static HelloWorld app;
    static CapCityReportsOne capOne;
    static CountryReportsOne countyOne;

    /**
     * connect to the database before performing tests
     */
    @BeforeAll
    static void init()
    {
        app = new HelloWorld();
        app.connect("localhost:33060", 30000);

        capOne = new CapCityReportsOne();
        countyOne = new CountryReportsOne();
    }

    /**
     * Tests integration between db connection, capital city class & and capCityWorld report method
     */
    @Test
    void testCapCityClass_dbQuery()
    {
        // get an arraylist with top 3 most populated world capital cities
        ArrayList<CapitalCity> testCapCityList = capOne.CapCityWorld(app.con, 3);

        // take top entry from list and store as CapCity object
        CapitalCity capCity = testCapCityList.get(0);

        // check details for correct result - expected output Seoul, South korea
        assertEquals(capCity.capCityPop, 9981619);
        assertEquals(capCity.capCityName, "Seoul");
        assertEquals(capCity.countryName, "South Korea");
    }

    /**
     * Tests integration between db connection, country class & and countryWorld report method
     */
    @Test
    void testCountryClass_dbQuery()
    {
        // get an arraylist with top 3 most populated countries
        ArrayList<Country> testCountryList = countyOne.World(app.con, 3);

        // take top entry from list and store as Country object
        Country country = testCountryList.get(0);

        // check details for correct result - expected output China
        assertEquals(country.Population, 1277558000);
        assertEquals(country.Name, "China");
        assertEquals(country.Code, "CHN");
    }


}