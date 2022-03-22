import com.napier.sem.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    static HelloWorld app;
    static CapCityReportsOne capOne;
    static CapCityReportsTwo capTwo;
    static CountryReportsOne countryOne;
    static CountryReportsTwo countryTwo;

    @BeforeAll
    static void init()
    {
        app = new HelloWorld();
        capOne = new CapCityReportsOne();
        countryOne = new CountryReportsOne();
        countryTwo = new CountryReportsTwo();
    }

    //region - testing CapCity methods

    /**
     * Test capCityOne SendToOutput method with null value input
     */
    @Test
    void testCapCityOneSendToOutput_NULL(){

        capOne.sendToOutput(null, 1);

    }

    /**
     * Test capCityOne Output method with null value input
     */
    @Test
    void testCapCityOneOutput_NULL(){

        capOne.output(null);

    }

    /**
     * Test capCityTwo Output method with null value input
     */
    @Test
    void testCapCityTwoOutput_NULL(){

        capTwo.outputLimit(null, 3);

    }

    /**
     * Test capCityTwo Output method with Invalid limit value input
     */
    @Test
    void testCapCityTwoOutput_INVALID_LIMIT(){

        // create test capCity object
        CapitalCity test = new CapitalCity();
        // create test cap city list
        ArrayList<CapitalCity> testList = new ArrayList<>();
        // add object to list
        testList.add(test);

        // run test
        capTwo.outputLimit(testList, 0);

    }

    //endregion

    //region - testing country methods

    /**
     * Test country SendToOutput method with null value input
     */
    @Test
    void testCountryOneSendToOutput_NULL(){

        countryOne.sendToOutput(null, 1);

    }

    /**
     * Test country Output method with null value input
     */
    @Test
    void testCountryOneOutput_NULL(){

        countryOne.output(null);

    }

    /**
     * Test country Output method with null value input
     */
    @Test
    void testCountryTwoOutput_NULL(){

        countryTwo.outputLimit(null, 3);

    }

    /**
     * Test country Output method with Invalid limit value input
     */
    @Test
    void testCountryTwoOutput_INVALID_LIMIT(){

        // create test capCity object
        Country test = new Country();
        // create test cap city list
        ArrayList<Country> testList = new ArrayList<>();
        // add object to list
        testList.add(test);

        // run test
        countryTwo.outputLimit(testList, 0);

    }

    //endregion
}