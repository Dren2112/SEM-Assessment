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

    CityReportsTwo cp= new CityReportsTwo();
    /**
     * All the cities in the world organised by largest population to smallest.
     */
    public void CityWorld(Connection con,int limit){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "Select city.ID, city.Name,country.name,city.District, city.population from city join country on city.countrycode= country.code ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<City> cityworld = new ArrayList<City>();
            //populate arraylist
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("city.ID");
                city.Name = rset.getString("city.Name");
                city.countryname= rset.getString("country.name");
                city.District=rset.getString("city.District");
                city.Popluation = rset.getInt("city.population");

                cityworld.add(city);
            }

            if(cityworld==null)
            {
                System.out.println("Your list is empty");

            }
            else
            {
                if(limit==-1)
                {
                    display(cityworld);
                }
                else
                {
                    cp.Display(cityworld,limit);
                }
            }
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
    public void CityContinent(Connection con,int limit){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="Select city.ID, city.Name,country.name,city.Population,country.continent,city.district from city join country on city.Countrycode=country.code where city.Countrycode=country.code AND country.continent= 'Asia' ORDER BY city.population DESC";
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
                city.District=rset.getString("city.district");

                citycontinent.add(city);
            }

            if(citycontinent==null)
            {
                System.out.println("Your list is empty");

            }
            else
            {
                if(limit==-1)
                {
                    displayone(citycontinent);
                }
                else
                {
                    cp.Display(citycontinent,limit);
                }
            }

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
      public void CityRegion(Connection con,int limit){
          try {
              // Create an SQL statement
              Statement stmt = con.createStatement();
              // Create string for SQL statement
              String strSelect ="Select city.ID, city.Name,country.name,city.Population,country.region,city.district from city join country on city.Countrycode=country.code where city.Countrycode=country.code AND country.region= 'Southern and Central Asia' ORDER BY city.population DESC";
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
                  city.District=rset.getString("city.district");
                  cityregion.add(city);
              }


              if(cityregion==null)
              {
                  System.out.println("Your list is empty");

              }
              else
              {
                  if(limit==-1)
                  {

                      displaytwo(cityregion);
                  }
                  else
                  {
                      cp.Display(cityregion,limit);
                  }
              }
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
    public void CityCountry(Connection con,int limit){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="Select city.ID, city.Name,country.name,city.Population ,city.district from city join country on city.Countrycode=country.code where city.Countrycode=country.code AND country.name= 'India' ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<City> citycountry = new ArrayList<City>();
            //populate arraylist
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.Popluation = rset.getInt("population");
                city.countryname=rset.getString("country.name");
                city.District=rset.getString("city.district");

                citycountry.add(city);
            }

            if(citycountry==null)
            {
                System.out.println("Your list is empty");

            }
            else
            {
                if(limit==-1)
                {
                    displaythree(citycountry);
                }
                else
                {
                    cp.Display(citycountry,limit);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }
    public void displaythree(ArrayList<City> ct3) throws InterruptedException {
        System.out.println("All the cities in specified region organsied by largest population to smallest");
        System.out.println("Processing.....");
        Thread.sleep(900);
        System.out.println("\n");
        System.out.println("\tID\t\t\t\t\t\t\tName\t\t\t\t\t\t\t\t\t\t\t\t\tCountryName\t\t\t\t\t\t\t\t\t\t\t\t\tpopulation\t\t");
        for (int i = 0; i < ct3.size(); i++) {
            System.out.println("\t" + ct3.get(i).ID + "\t\t\t\t\t\t\t" + ct3.get(i).Name + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + ct3.get(i).countryname + "\t\t\t\t\t\t\t\t\t\t\t\t\t" +ct3.get(i).Popluation);
        }

    }

    /**
     * All the cities in a district organised by largest population to smallest.
     */
    public void CityDistrict(Connection con,int limit){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="Select city.ID, city.Name, city.District, city.Population,country.name from city join country on city.countrycode= country.code where district='New South Wales' ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<City> citydistrict = new ArrayList<City>();
            //populate arraylist
            while (rset.next()) {
                City city = new City();
                city.ID = rset.getInt("city.ID");
                city.Name = rset.getString("city.Name");
                city.Popluation = rset.getInt("city.Population");
                city.District=rset.getString("city.District");
                city.countryname=rset.getString("country.name");

                citydistrict.add(city);
            }
            if(citydistrict==null)
            {
                System.out.println("Your list is empty");

            }
            else
            {
                if(limit==-1)
                {
                    displayfour(citydistrict);
                }
                else
                {
                    cp.Display(citydistrict,limit);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }



    }
    public void displayfour(ArrayList<City> ct4) throws InterruptedException {
        System.out.println("All the cities in specified region organsied by largest population to smallest");
        System.out.println("Processing.....");
        Thread.sleep(900);
        System.out.println("\n");
        System.out.println("\tID\t\t\t\t\t\t\tName\t\t\t\t\t\t\t\t\t\t\t\t\tDistrict\t\t\t\t\t\t\t\t\t\t\t\t\tpopulation\t\t");
        for (int i = 0; i < ct4.size(); i++) {
            System.out.println("\t" + ct4.get(i).ID + "\t\t\t\t\t\t\t" + ct4.get(i).Name + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + ct4.get(i).District + "\t\t\t\t\t\t\t\t\t\t\t\t\t" +ct4.get(i).Popluation);
        }

    }

}
