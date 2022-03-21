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

    // Capital City Method Tests ---------------------------------------------
    /**
     * Check that capCityWorld method returns correct number of results
     */
    @Test
    void testCapCityWorld()
    {
        // get the number of capital cities returned by the query
        int result = capOne.CapCityWorld(app.con, -1).size();

        // check result - expected 232
        assertEquals(232, result);
    }

    /**
     * Check that capCityContinent method returns correct number of results
     */
    @Test
    void testCapCityContinent()
    {
        // get the number of capital cities returned by the query
        int result = capOne.CapCityContinent(app.con, -1).size();

        // check result - expected 3
        assertEquals(46, result);
    }

    /**
     * Check that capCityRegion method returns correct number of results
     */
    @Test
    void testCapCityRegion()
    {
        // get the number of capital cities returned by the query
        int result = capOne.CapCityRegion(app.con, -1).size();

        // check result - expected 3
        assertEquals(9, result);
    }

    // Country Method Tests -------------------------------------------------
    /**
     * Check that countryWorld method returns correct number of results
     */
    @Test
    void testCountryWorld()
    {
        // get the number of capital cities returned by the query
        int result = countyOne.World(app.con, -1).size();

        // check result - expected 232
        assertEquals(232, result);
    }

    /**
     * Check that countryWorld method returns correct number of results
     */
    @Test
    void testCountryContinent()
    {
        // get the number of capital cities returned by the query
        int result = countyOne.Continent(app.con, -1).size();

        // check result - expected 46
        assertEquals(46, result);
    }

    /**
     * Check that countryWorld method returns correct number of results
     */
    @Test
    void testCountryRegion()
    {
        // get the number of capital cities returned by the query
        int result = countyOne.Region(app.con, -1).size();

        // check result - expected 9
        assertEquals(9, result);
    }

}