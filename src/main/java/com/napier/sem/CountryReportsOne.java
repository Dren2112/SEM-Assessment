package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #11 "Country Reports 1"
 */
public class CountryReportsOne {

    // A METHOD FOR THE TEST QUERY
    public void Test(Connection con){

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

    /**
     * All the countries in the world organised by largest population to smallest.
     */
    public void World(Connection con){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name  FROM country, city WHERE capital = city.ID ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<Country> world = new ArrayList<Country>();
            //populate arraylist
            while (rset.next())
            {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("country.Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("country.Population");
                country.Capital = rset.getString("city.Name");
                
                world.add(country);
            }
            //send arraylist to output
            output(world);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }


    }

    /**
     * All the countries in a continent organised by largest population to smallest.
     */
    public void Continent(Connection con){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name  FROM country, city WHERE capital = city.ID AND continent = 'Europe' ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<Country> world = new ArrayList<Country>();
            //populate arraylist
            while (rset.next())
            {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("country.Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("country.Population");
                country.Capital = rset.getString("city.Name");

                world.add(country);
            }
            //send arraylist to output
            output(world);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }

    /**
     * All the countries in a region organised by largest population to smallest.
     */
    public void Region(Connection con){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name  FROM country, city WHERE capital = city.ID AND region = 'Western Europe' ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<Country> world = new ArrayList<Country>();
            //populate arraylist
            while (rset.next())
            {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("country.Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("country.Population");
                country.Capital = rset.getString("city.Name");

                world.add(country);
            }
            //send arraylist to output
            output(world);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }

    /**
     * method to output all country arraylists
     */
    public void output(ArrayList<Country> contents){
        System.out.println("Code Name Continent Region Population Capital");
        for (int i = 0; i < contents.size(); i++)
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
