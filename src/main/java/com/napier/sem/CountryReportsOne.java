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
    public ArrayList<Country> World(Connection con, int limit){
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
            sendToOutput(world, limit);

            return world;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

            return null;
        }


    }

    /**
     * All the countries in a continent organised by largest population to smallest.
     */
    public ArrayList<Country> Continent(Connection con, int limit){
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
            sendToOutput(world, limit);

            return world;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

            return null;
        }



    }

    /**
     * All the countries in a region organised by largest population to smallest.
     */
    public ArrayList<Country> Region(Connection con, int limit){
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
            sendToOutput(world, limit);

            return world;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

            return null;
        }



    }

    /**
     * Process an arraylist and send to print
     *
     * @param world
     * @param limit
     */
    public void sendToOutput(ArrayList<Country> world, int limit ){

        if (world == null){
            System.out.println("No Data To Send");
        }
        else{

            //send arraylist to output
            if (limit == -1) {
                output(world);
            }
            else {
                CountryReportsTwo.outputLimit(world, limit);
            }
        }
    }

    /**
     * method to output all country arraylists
     */
    public void output(ArrayList<Country> contents){

        if (contents == null){
            System.out.println("No Data Found");
        }
        else{
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("Code              ||              Country-Name              ||              Continent-Name              ||              Region-Name              ||              Population             ||                 Capital-Name");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < contents.size(); i++)
            {

                // prepare string
                String one = String.format("%-40s", contents.get(i).Code);
                String two = String.format("%-55s", contents.get(i).Name);
                String three = String.format("%-55s", contents.get(i).Continent);
                String four = String.format("%-55s", contents.get(i).Region);
                String five = String.format("%-55s", contents.get(i).Population);
                String six = String.format("%-16s", contents.get(i).Capital);

                // print string
                System.out.println(one + two + three + four + five + six);
            }
        }
    }
}
