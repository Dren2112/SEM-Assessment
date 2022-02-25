package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountryReportsOne {

    /**
     * Class Description
     * This class contains the methods required to produce reports for issue #11 "Country Reports 1"
     */

    // All the countries in the world organised by largest population to smallest.
    public void World(Connection con){

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name FROM city WHERE ID = 1 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                System.out.println(rset.getString("Name"));
                // system should output Kabul as result
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    // All the countries in a continent organised by largest population to smallest.
    public void Continent(Connection con){

    }

    // All the countries in a region organised by largest population to smallest.
    public void Region(Connection con){

    }
}
