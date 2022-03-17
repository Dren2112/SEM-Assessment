package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #13 "City Reports 1"
 */
public class CityReportsOne {

    /**
     * All the cities in the world organised by largest population to smallest.
     */
    public void CityWorld(Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "Select ID, Name, District, population from city ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<City> cityworld = new ArrayList<City>();
            //populate arraylist
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.District = rset.getString("District");
                city.Popluation = rset.getInt("population");

                cityworld.add(city);
                display(cityworld);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }
    public void display(ArrayList<City> ct)
    {
        System.out.println("\tID |\tName |\tDistrict |\tpopulation");
        for(int i=0; i<ct.size();i++)
        {
            System.out.println("\t"+ct.get(i).ID+"|\t"+ct.get(i).Name+"|\t"+ct.get(i).District+"|\t"+ct.get(i).Popluation);
        }

    }
    /**
     * All the cities in a continent organised by largest population to smallest.
     */
    public void CityContinent(Connection con){

    }

    /**
     * All the cities in a region organised by largest population to smallest.
     */
    public void CityRegion(Connection con){

    }

    /**
     * All the cities in a country organised by largest population to smallest.
     */
    public void CityCountry(Connection con){

    }

    /**
     * All the cities in a district organised by largest population to smallest.
     */
    public void CityDistrict(Connection con){

    }
}
