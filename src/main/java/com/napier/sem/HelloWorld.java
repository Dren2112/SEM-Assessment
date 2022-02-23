package com.napier.sem;

import java.sql.*;

public class HelloWorld
{
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

    /** ---------------------------------------------------------------------------------------
     * Generate Test SQL Query
     */
    public void getTestData()
    {
        // a test sql query
        // asks to return the name of the city with the ID of 1
        // prints the result (expected result: Kabul)

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

    public static void main(String[] args)
    {
        // Create new Application
        HelloWorld app = new HelloWorld();

        // Connect to database
        app.connect();

        // Attempt Test Query
        app.getTestData();

        // Disconnect from database
        app.disconnect();
    }
}