package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #14 "City Reports 2"
 */
public class CityReportsTwo {

    /**
     * The top N populated cities in the world where N is provided by the user.
     */
    public void Display(ArrayList<City> city, int limit) {
        System.out.println("\tID\t\t\t\t\tNAME\t\t\t\t\t COUNTRY\t\t\t\t\tDISTRICT\t\t\t\t\tPOPULATION");
        for (int i = 0; i < limit; i++) {
            System.out.println("\t" + city.get(i).ID + "\t\t\t\t\t" + city.get(i).Name + "\t\t\t\t\t"
                    + city.get(i).countryname + "\t\t\t\t\t" + city.get(i).District +
                    "\t\t\t\t\t" + city.get(i).Popluation);
        }
    }
}
