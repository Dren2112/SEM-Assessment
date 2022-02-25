package com.napier.sem;

import java.sql.*;

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
            System.exit(-1);
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


    public static void main(String[] args)
    {
        // Create new Application
        HelloWorld app = new HelloWorld();

        // Connect to database
        app.connect();

        // Attempt Test Query (test query method is located in CountryReportOne class)
        app.countryOne.Test(app.con);
        System.out.println("It Worked!!!");

        // Disconnect from database
        app.disconnect();
    }
}