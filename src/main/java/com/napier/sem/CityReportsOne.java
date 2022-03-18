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

                city.Popluation = rset.getInt("population");

                cityworld.add(city);
            }
            display(cityworld);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }
    public void display(ArrayList<City> ct) throws InterruptedException {
        System.out.println("All the cities in the world organsied by largest population to smallest");
        System.out.println("Processing.....");
         Thread.sleep(200);
         System.out.println("\n");
        System.out.println("\tID\t\t\t\tName\t\t\tpopulation");
        for(int i=0; i<ct.size();i++)
        {
            System.out.println("\t"+ct.get(i).ID+"\t\t\t\t\t\t\t"+ct.get(i).Name+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+ct.get(i).Popluation);
        }

    }
    /**
     * All the cities in a continent organised by largest population to smallest.
     */
    public void CityContinent(Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="Select city.ID, city.Name,country.name,city.Population,country.continent from city join country on city.Countrycode=country.code where city.Countrycode=country.code AND country.continent= 'Asia' ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<City> citycontinent = new ArrayList<City>();
            //populate arraylist
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.continent=rset.getString("country.continent");
                city.Popluation = rset.getInt("population");
                city.countryname=rset.getString("country.name");

                citycontinent.add(city);
            }
            displayone(citycontinent);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }
    public void displayone(ArrayList<City> ct1) throws InterruptedException {
        System.out.println("All the cities in a continent organsied by largest population to smallest");
        System.out.println("Processing.....");
        Thread.sleep(900);
        System.out.println("\n");
        System.out.println("\tID\t\t\t\t\t\t\tName\t\t\t\t\t\t\t\t\t\t\t\t\tCountryName\t\t\t\t\t\t\t\t\t\t\t\t\tContinent\t\t\t\t\t\t\t\t\t\t\t\t\tpopulation\t\t");
        for(int i=0; i<ct1.size();i++)
        {
            System.out.println("\t"+ct1.get(i).ID+"\t\t\t\t\t\t\t"+ct1.get(i).Name+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+ct1.get(i).continent+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+ct1.get(i).Popluation);
        }

    }

    /**
     * All the cities in a region organised by largest population to smallest.
     */
      public void CityRegion(Connection con){
          try {
              // Create an SQL statement
              Statement stmt = con.createStatement();
              // Create string for SQL statement
              String strSelect ="Select city.ID, city.Name,country.name,city.Population,country.region from city join country on city.Countrycode=country.code where city.Countrycode=country.code AND country.region= 'Southern and Central Asia' ORDER BY city.population DESC";
              // Execute SQL statement
              ResultSet rset = stmt.executeQuery(strSelect);

              // create arraylist of result
              ArrayList<City> cityregion = new ArrayList<City>();
              //populate arraylist
              while (rset.next()) {
                  City city = new City();
                  city.ID = rset.getInt("ID");
                  city.Name = rset.getString("Name");
                  city.region=rset.getString("country.region");
                  city.Popluation = rset.getInt("population");
                  city.countryname=rset.getString("country.name");

                  cityregion.add(city);
              }
              displaytwo(cityregion);

          } catch (Exception e) {
              System.out.println(e.getMessage());
              System.out.println("Failed to get details");
          }



      }
    public void displaytwo(ArrayList<City> ct2) throws InterruptedException {
        System.out.println("All the cities in specified region organsied by largest population to smallest");
        System.out.println("Processing.....");
        Thread.sleep(900);
        System.out.println("\n");
        System.out.println("\tID\t\t\t\t\t\t\tName\t\t\t\t\t\t\t\t\t\t\t\t\tCountryName\t\t\t\t\t\t\t\t\t\t\t\t\tRegion\t\t\t\t\t\t\t\t\t\t\t\t\tpopulation\t\t");
        for(int i=0; i<ct2.size();i++)
        {
            System.out.println("\t"+ct2.get(i).ID+"\t\t\t\t\t\t\t"+ct2.get(i).Name+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+ct2.get(i).region+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+ct2.get(i).Popluation);
        }

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
