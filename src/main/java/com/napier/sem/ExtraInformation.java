package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #18 "Extra Information"
 */
public class ExtraInformation {

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
     * The population of the world.
     */
    public ArrayList<ExInfoPopulation> ExWorld(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create a string for SQL Statement
            String strSelect =
                    "SELECT SUM(Population) AS 'World Population' FROM country;";
            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Create arraylist out of the result
            ArrayList<ExInfoPopulation> world = new ArrayList<>();
            //Populate arraylist
            while (rset.next()) {
                ExInfoPopulation population = new ExInfoPopulation();
                population.Population = rset.getLong("World Population");

                world.add(population);
            }
            //Send arraylist to output
            sendToOutput(world,limit);

            return world;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }

    }

    /**
     * The population of a continent.
     */
    public ArrayList<ExInfoPopulation> ExContinent(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create a string for SQL Statement
            String strSelect =
                    "SELECT SUM(Population) AS 'Europe Population' FROM country WHERE Continent = 'Europe';";
            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Create arraylist out of the result
            ArrayList<ExInfoPopulation> world = new ArrayList<>();
            //Populate arraylist
            while (rset.next()) {
                ExInfoPopulation population = new ExInfoPopulation();
                population.Population = rset.getLong("Europe Population");

                world.add(population);
            }
            //Send arraylist to output
            sendToOutput(world,limit);

            return world;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of a region.
     */
    public ArrayList<ExInfoPopulation> ExRegion(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create a string for SQL Statement
            String strSelect =
                    "SELECT SUM(Population) AS 'Western Europe Population' FROM country WHERE Region = 'Western Europe';";
            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //Create arraylist out of the result
            ArrayList<ExInfoPopulation> world = new ArrayList<>();

            //Populate arraylist
            while (rset.next()) {
                ExInfoPopulation population = new ExInfoPopulation();
                population.Population = rset.getLong("Western Europe Population");

                world.add(population);
            }
            //Send arraylist to output
            sendToOutput(world,limit);

            return world;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }


    }

    /**
     * The population of a country.
     */
    public ArrayList<ExInfoPopulation> ExCountry(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create a string for SQL Statement
            String strSelect =
                    "SELECT Population AS 'France Population' FROM country WHERE name = 'France';";
            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //Create arraylist out of the result
            ArrayList<ExInfoPopulation> world = new ArrayList<>();

            //Populate arraylist
            while (rset.next()) {
                ExInfoPopulation population = new ExInfoPopulation();
                population.Population = rset.getLong("France Population");

                world.add(population);
            }
            //Send arraylist to output
            sendToOutput(world,limit);

            return world;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }

    }

    /**
     * The population of a district.
     */
    public ArrayList<ExInfoPopulation> ExDistrict(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create a string for SQL Statement
            String strSelect =
                    "SELECT SUM(Population) AS 'Utrecht Population' FROM city WHERE District = 'Utrecht';";
            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //Create arraylist out of the result
            ArrayList<ExInfoPopulation> world = new ArrayList<>();

            //Populate arraylist
            while (rset.next()) {
                ExInfoPopulation population = new ExInfoPopulation();
                population.Population = rset.getLong("Utrecht Population");

                world.add(population);
            }
            //Send arraylist to output
            sendToOutput(world,limit);

            return world;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }


    }

    /**
     * The population of a city.
     */
    public ArrayList<ExInfoPopulation> ExCity(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create a string for SQL Statement
            String strSelect =
                    "SELECT Population AS 'Berlin Population' FROM city WHERE name = 'Berlin';";
            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //Create arraylist out of the result
            ArrayList<ExInfoPopulation> world = new ArrayList<>();

            //Populate arraylist
            while (rset.next()) {
                ExInfoPopulation population = new ExInfoPopulation();
                population.Population = rset.getLong("Berlin Population");

                world.add(population);
            }
            //Send arraylist to output
            sendToOutput(world,limit);

            return world;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }



    public void sendToOutput(ArrayList<ExInfoPopulation> world, int limit ){

        if (world == null){
            System.out.println("No Data To Send");
        }
        else{

            //send arraylist to output
            if (limit == -1) {
                output(world);
            }
        }
    }

    public void output(ArrayList<ExInfoPopulation> contents){

        if (contents == null){
            System.out.println("No Data Found");
        }
        else{

            System.out.println("------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < contents.size(); i++)
            {
                System.out.println(
                        contents.get(i).Population);
            }
        }
    }






}