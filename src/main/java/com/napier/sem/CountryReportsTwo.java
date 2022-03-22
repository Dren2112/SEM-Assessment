package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #12 "Country Reports 2"
 */
public class CountryReportsTwo {

    /**
     * asks the user for variable N
     */
    public int GetLimit(Connection con){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many entries would you like to see?");

        String amountToShow = scan.nextLine();
        return Integer.parseInt(amountToShow);
    }

    /**
    * outputs the results of a previous report, only showing a certain amount of lines, specified by limit
     */
    public static void outputLimit(ArrayList<Country> contents, int limit){

        if (contents == null){
            System.out.println("No Data Found");
        }
        else if (limit < 1){
            System.out.println("Limit must be more than 0");
        }
        else{

            System.out.println("Code Name Continent Region Population Capital");
            for (int i = 0; i < limit; i++)
            {
                System.out.println(
                        contents.get(i).Code
                                + " " + contents.get(i).Name
                                + " " + contents.get(i).Continent
                                + " " + contents.get(i).Region
                                + " " + String.valueOf(contents.get(i).Population)
                                + " " + contents.get(i).Capital);
            }
        }

    }
}
