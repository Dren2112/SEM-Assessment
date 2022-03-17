package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #15 "Capital City Reports 1"
 *
 * A capital city report requires the following columns:
 *
 * Name.
 * Country.
 * Population.
 */
public class CapCityReportsOne {


    /**
     * All the capital cities in the world organised by largest population to smallest.
     *
     * @param con - Database Connection
     */
    public void CapCityWorld(Connection con){

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<CapitalCity> world = new ArrayList<CapitalCity>();
            //populate arraylist with data from result
            while (rset.next())
            {
                CapitalCity capCity = new CapitalCity();
                capCity.capCityName = rset.getString("city.Name");
                capCity.countryName = rset.getString("country.Name");
                capCity.capCityPop = rset.getInt("city.Population");

                world.add(capCity);
            }

            // send data to output method
            output(world);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    /**
     * All the capital cities in a continent organised by largest population to smallest.
     *
     * @param con - Database Connection
     */
    public void CapCityContinent(Connection con){

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON city.ID = country.Capital WHERE continent = 'Europe' ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<CapitalCity> world = new ArrayList<CapitalCity>();
            //populate arraylist with data from result
            while (rset.next())
            {
                CapitalCity capCity = new CapitalCity();
                capCity.capCityName = rset.getString("city.Name");
                capCity.countryName = rset.getString("country.Name");
                capCity.capCityPop = rset.getInt("city.Population");

                world.add(capCity);
            }

            // send data to output method
            output(world);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    /**
     * All the capital cities in a region organised by largest to smallest.
     *
     * @param con - Database Connection
     */
    public void CapCityRegion(Connection con){

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON city.ID = country.Capital WHERE region = 'Western Europe' ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<CapitalCity> world = new ArrayList<CapitalCity>();
            //populate arraylist with data from result
            while (rset.next())
            {
                CapitalCity capCity = new CapitalCity();
                capCity.capCityName = rset.getString("city.Name");
                capCity.countryName = rset.getString("country.Name");
                capCity.capCityPop = rset.getInt("city.Population");

                world.add(capCity);
            }

            // send data to output method
            output(world);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }


    /**
     * method to output all Capital City arraylists
     *
     * @param contents - the arraylist containing the data to output
     */
    public void output(ArrayList<CapitalCity> contents){

        System.out.println("------------------------------------------------------------------");
        System.out.println("Capital-Name     ||     Country-Name     ||     Capital-Population");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < contents.size(); i++)
        {
            System.out.println(
                    contents.get(i).capCityName + " -- " + contents.get(i).countryName + " -- " + String.valueOf(contents.get(i).capCityPop));
        }
    }

}
