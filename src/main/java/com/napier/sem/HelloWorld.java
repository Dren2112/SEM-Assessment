package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class HelloWorld
{
    /** ---------------------------------------------------------------------------------------
     * Initialise report classes
     */
    private final CountryReportsOne countryOne = new CountryReportsOne();
    private final CountryReportsTwo CountryTwo = new CountryReportsTwo();
    private final CityReportsOne cityOne = new CityReportsOne();
    private final CityReportsTwo cityTwo = new CityReportsTwo();
    private final CapCityReportsOne capOne = new CapCityReportsOne();
    private final CapCityReportsTwo capTwo = new CapCityReportsTwo();
    private final PopulationReports popRep = new PopulationReports();
    private final ExtraInformation exInfo = new ExtraInformation();
    private final LanguageReports LangRep = new LanguageReports();


    /** ---------------------------------------------------------------------------------------
     * Connection to MySQL database.
     */
    public Connection con = null;

    /** ---------------------------------------------------------------------------------------
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /** ---------------------------------------------------------------------------------------
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // Create new Application
        HelloWorld app = new HelloWorld();

        // Connect to database
        if(args.length < 1){
            app.connect("localhost:33060", 30000);
        }else{
            app.connect(args[0], Integer.parseInt(args[1]));
        }

       // execute countryOne queries
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Countries of the world organised by largest population to smallest.");
        app.countryOne.World(app.con, -1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Countries of Europe organised by largest population to smallest.");
        app.countryOne.Continent(app.con, -1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Countries of Western Europe organised by largest population to smallest.");
        app.countryOne.Region(app.con, -1);
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        // execute countryTwo queries
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top N Countries of the world organised by largest population to smallest.");
        app.countryOne.World(app.con, 5);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top N Countries of Europe organised by largest population to smallest.");
        app.countryOne.Continent(app.con, 5);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top N Countries of Western Europe organised by largest population to smallest.");
        app.countryOne.Region(app.con, 5);
        System.out.println(" ");
        System.out.println(" ");


        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        // execute CapCityOne queries
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Capital cities of The World by population in descending order");
        app.capOne.CapCityWorld(app.con, -1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Capital cities of Europe by population in descending order");
        app.capOne.CapCityContinent(app.con, -1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Capital cities of Western Europe by population in descending order");
        app.capOne.CapCityRegion(app.con, -1);
        System.out.println(" ");
        System.out.println(" ");

        // execute CapCityOne queries
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Top 5 Capital cities of The World by population in descending order");
        app.capOne.CapCityWorld(app.con, 5);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Top 5 Capital cities of Europe by population in descending order");
        app.capOne.CapCityContinent(app.con, 5);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Top 5 Capital cities of Western Europe by population in descending order");
        app.capOne.CapCityContinent(app.con, 5);
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Cities of the world by population in descending order");
        app.cityOne.CityWorld(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Cities in Asia by population in descending order");
        app.cityOne.CityContinent(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Cities in Southern and Central Asia by population in descending order");
        app.cityOne.CityRegion(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Cities in India by population in descending order");
        app.cityOne.CityCountry(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Top 5 Cities of the world by population in descending order");
        app.cityOne.CityWorld(app.con,5);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top 5 Cities in Asia by population in descending order");
        app.cityOne.CityContinent(app.con,5);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top 5 Cities in Southern and Central Asia by population in descending order");
        app.cityOne.CityRegion(app.con,6);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top 5 Cities in India by population in descending order");
        app.cityOne.CityCountry(app.con,5);
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Cities in New South Wales by population in descending order");
        app.cityOne.CityDistrict(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("top 5 Cities in New South Wales by population in descending order");
        app.cityOne.CityDistrict(app.con,5);
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
        app.popRep.PopContinent(app.con);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("The population of people, people living in cities, and people not living in cities in each region.");
        app.popRep.PopRegion(app.con);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("The population of people, people living in cities, and people not living in cities in each country.");
        app.popRep.PopCountry(app.con);
        System.out.println(" ");
        System.out.println(" ");

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        //The code below is used to output the language report. It prints information only on the specified languages.
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Language Report");
        app.LangRep.LanguageReport(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");


        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        //The code below is used to output the Extra Information reports, which asked for the population of various parts of the world.
        //Below is the output for World Population
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Information on the World Population");
        app.exInfo.ExWorld(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        //Below is the output for Continent Population, the specified continent is Europe.
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Information on Continent Population, with the continent being Europe");
        app.exInfo.ExContinent(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        //Below is the output for Region Population, the specified region is Western Europe.
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Information on Region Population, with the region being Western Europe");
        app.exInfo.ExRegion(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        //Below is the output for Country Population, the specified country is France.
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Information on Country Population, with the country being France");
        app.exInfo.ExCountry(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        //Below is the output for District Population, the specified district is Utrecht
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Information on District Population, with the district being Utrecht in the Netherlands");
        app.exInfo.ExDistrict(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");

        //Below is the output for City Population, the specified city is Berlin.
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Information on City Population, with the city being Berlin ");
        app.exInfo.ExCity(app.con,-1);
        System.out.println(" ");
        System.out.println(" ");


        // Disconnect from database
        app.disconnect();
    }
}

