package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the method required to output reports for issue #16 "Capital City Reports 2"
 *
 *
 */
public class CapCityReportsTwo {


    /**
     * outputs the results of a previous report, only showing a certain amount of lines, specified by limit
     *
     * @param contents - the arraylist containing the data to output
     * @param limit - the number of entries to show
     */
    public static void outputLimit(ArrayList<CapitalCity> contents, int limit){

        System.out.println("------------------------------------------------------------------");
        System.out.println("Capital-Name     ||     Country-Name     ||     Capital-Population");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < limit; i++)
        {
            // prepare string
            String one = String.format("%-40s", contents.get(i).capCityName);
            String two = String.format("%-55s", contents.get(i).countryName);
            String three = String.format("%-16s", contents.get(i).capCityPop);

            // print string
            System.out.println(one + two + three);
        }
    }

}