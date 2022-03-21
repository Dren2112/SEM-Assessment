//package com.napier.sem;
import com.napier.sem.HelloWorld;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyIntegrationTest
{
    static HelloWorld app;

    /**
     * connect to the database before performing tests
     */
    @BeforeAll
    static void init()
    {
        app = new HelloWorld();
        app.connect("localhost:33060", 30000);

    }

    
    @Test
    void testGetCountry()
    {
        // Sample test - must be replaced with real test
        assertEquals(5, 5);
    }

    @Test
    void testGetCity()
    {
        // Sample test - must be replaced with real test
        assertNotEquals(4,5);
    }

}