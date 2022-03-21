import com.napier.sem.CapCityReportsOne;
import com.napier.sem.CapitalCity;
import com.napier.sem.CountryReportsOne;
import com.napier.sem.HelloWorld;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    static HelloWorld app;
    static CapCityReportsOne capOne;
    static CountryReportsOne countyOne;

    @BeforeAll
    static void init()
    {
        app = new HelloWorld();
        app.connect("localhost:33060", 30000);

        capOne = new CapCityReportsOne();
        countyOne = new CountryReportsOne();
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