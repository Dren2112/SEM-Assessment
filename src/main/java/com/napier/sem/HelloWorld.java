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
    private Connection con = null;

    /** ---------------------------------------------------------------------------------------
     * Connect to the MySQL database.
     */
    public void connect()
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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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
        app.connect();

        // execute queries
        app.countryOne.World(app.con, -1);
        app.countryOne.Continent(app.con, -1);
        app.countryOne.Region(app.con, -1);

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        //int limit = app.CountryTwo.GetLimit(app.con);
        app.countryOne.World(app.con, 5);
        //limit = app.CountryTwo.GetLimit(app.con);
        app.countryOne.Continent(app.con, 5);
        //limit = app.CountryTwo.GetLimit(app.con);
        app.countryOne.Region(app.con, 5);

        // White Space
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        // execute CapCity queries
        System.out.println("Capital cities of The World by population in descending order");
        app.capOne.CapCityWorld(app.con);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Capital cities of Europe by population in descending order");
        app.capOne.CapCityContinent(app.con);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Capital cities of Western Europe by population in descending order");
        app.capOne.CapCityRegion(app.con);
        System.out.println(" ");
        System.out.println(" ");
              System.out.println("\n\n");

            System.out.println("\t\t\t\t***********WELCOME IN THE PROGRAM OF POPULATION IN THE CITIES ***********");
            System.out.println("LOADING..........");
            Thread.sleep(1000);

            //CODE TO ORGANISED ALL THE POPULATION IN THE CITIES IN THE WORLD

        //CODE TO ORGANISED ALL THE POPULATION IN THE CITIES IN THE WORLD
        System.out.println("\t\t********************Program 1 *******************");
        System.out.println("As an organisation, we want to be able to list all the cities in the world in descending order, so that we can make a report on city population.");
        System.out.println("Processing......");
        Thread.sleep(1000);
        app.cityOne.CityWorld(app.con,-1);
        System.out.println("\n\n\n\n");
        System.out.println("");
        System.out.println("");


        // THIS CODE IS USED TO SHOW TOP N POPULATED CITIES IN THE WORLD
        System.out.println("\n\t\t*******************Program 2******************");
        System.out.println("As an organisation, we want to find the top N populated cities in the world where N is provided by the user, so that we can make a report on the based of top N populated cities.");
        Thread.sleep(1000);
        app.cityOne.CityWorld(app.con,6);

        //CODE TO ORGANISED ALL THE POPULATION IN THE CITIES IN A CONTINENT
        System.out.println("\t\t********************Program 3 *******************");
        System.out.println("As an organisation, we want to be able to list all the cities in a continent in descending order, so that we can make a report on city population.");
        System.out.println("Processing......");
        Thread.sleep(1000);
        app.cityOne.CityContinent(app.con,-1);
        System.out.println("");
        System.out.println("");
        System.out.println("");


        // THIS CODE IS USED TO SHOW TOP N POPULATED CITIES IN THE CONTINENT
        System.out.println("\t\t*********************Program 4********************");
        System.out.println("As an organisation, we want to find the top N populated cities in a continent where N is provided by the user, so that we can make a report on the based of top N populated cities.");
        Thread.sleep(1000);
        app.cityOne.CityContinent(app.con,6);

        // CODE TO ORGANISED ALL THE POPULATION OF THE CITIES IN A SPECIFIED REGION
        System.out.println("\t\t********************Program 5 *******************");
        System.out.println("As an organisation, we want to be able to list all the cities in a specified region in descending order, so that we can make a report on city population.");
        System.out.println("Processing......");
        Thread.sleep(1000);
        app.cityOne.CityRegion(app.con,-1);
        System.out.println("");
        System.out.println("");
        System.out.println("");


        // THIS CODE IS USED TO SHOW TOP N POPULATED CITIES IN THE REGION
        System.out.println("\t\t*************************Program 6***********************");
        System.out.println("As an organisation, we want to find the top N populated cities in a specified region where N is provided by the user, so that we can make a report on the based of top N populated cities.");
        Thread.sleep(1000);
        app.cityOne.CityRegion(app.con,6);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        //CODE TO ORGANISED ALL THE POPULATION OF THE CITIES IN A COUNTRY
        System.out.println("\t\t********************Program 7 *******************");
        System.out.println("As an organisation, we want to be able to list all the cities in a country in descending order, so that we can make a report on city population.");
        System.out.println("Processing......");
        Thread.sleep(1000);
        app.cityOne.CityCountry(app.con,-1);
        System.out.println("");
        System.out.println("");
        System.out.println("");


        // THIS CODE IS USED TO SHOW TOP N POPULATED CITIES IN THE COUNTRY
        System.out.println("\t\t**********************Program 8************************");
        System.out.println("As an organisation, we want to find the top N populated cities in a country where N is provided by the user, so that we can make a report on the based of top N populated cities.");
        Thread.sleep(1000);
        app.cityOne.CityCountry(app.con,6);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        //CODE TO ORGANISED ALL THE POPULATION OF THE CITIES IN A  DISTRICT
        System.out.println("\t\t********************Program 9 *******************");
        System.out.println("As an organisation, we want to be able to list all the cities in a district in descending order, so that we can make a report on city population.");
        System.out.println("Processing......");
        Thread.sleep(1000);
        app.cityOne.CityDistrict(app.con,-1);
        System.out.println("");
        System.out.println("");
        System.out.println("");


        // THIS CODE IS USED TO SHOW TOP N POPULATED CITIES IN THE DISTRICT
        System.out.println("\t\t**************************Program 10*******************");
        System.out.println("As an organisation, we want to find the top N populated cities in a district where N is provided by the user, so that we can make a report on the based of top N populated cities.");
        Thread.sleep(1000);
        app.cityOne.CityDistrict(app.con,4);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Disconnect from database
        app.disconnect();
    }
}
