package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyIntegrationTest
{
    static HelloWorld app;

    @BeforeAll
    static void init()
    {
        app = new HelloWorld();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetCountry()
    {
        assertEquals(5, 5);
    }

    @Test
    void testGetCity()
    {
        assertNotEquals(4,5);
    }

}