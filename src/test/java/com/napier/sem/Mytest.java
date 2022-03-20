package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class Mytest {
 static HelloWorld helloworld;
    @BeforeAll
    static void init()
    {
        helloworld = new HelloWorld();
    }
    @Test
    void printSalariesTestNull()
    {
        helloworld.printSalaries(null);
    }
}
