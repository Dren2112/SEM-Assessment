import com.napier.sem.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    static HelloWorld app;
    static CapCityReportsOne capOne;
    static CapCityReportsTwo capTwo;
    static CountryReportsOne countyOne;

    @BeforeAll
    static void init()
    {
        app = new HelloWorld();
        capOne = new CapCityReportsOne();
        countyOne = new CountryReportsOne();
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
}