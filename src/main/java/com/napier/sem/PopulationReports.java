package com.napier.sem;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #17 "Population Reports"
 */
public class PopulationReports {

    /**
     * The population of people, people living in cities, and people not living in cities in each continent.
     */
    public void PopContinent(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select  country.continent as continent_name,SUM(country.population) as total_population_continent,Round((SUM(city.population)/SUM(country.population)*100),3) as people_live_inside, ((SUM(country.population)-SUM(city.population))/SUM(country.population*100))as people_live_outside  from city join country on city.countrycode= country.code where country.continent='Asia'\n" +
                    " or Continent='Europe' or Continent='Africa' or Continent='North America' or Continent='South America'  or Continent = 'Oceania' or Continent= 'Antarctica'  Group by country.continent";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<Population> pop = new ArrayList<Population>();
            //populate arraylist
            while (rset.next()) {
                Population pop1 = new Population();
               pop1.continentname=rset.getString("continent_name");
               pop1.continent_pop=  rset.getLong("total_population_continent");
              pop1.people_live_inside= rset.getFloat("people_live_inside");
               pop1.people_live_outside= rset.getFloat("people_live_outside");
               pop.add(pop1);

            }
            if (pop == null) {
                System.out.println("Your list is empty");

            } else {
                    displayfour(pop);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }
        public void displayfour(ArrayList<Population> pop3) throws InterruptedException {
            System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
            System.out.println("Processing.....");
            Thread.sleep(900);
            System.out.println("\n");
            System.out.println("\tContinent_Name\t\t\t\t\t\t\t\t\t\tCountry Population\t\t\t\t\t\t\t\tPeople_Live_Inside_City\t\t\t\t\t\t\t\tPeople_Live_Outside_City");
            for (int i = 0; i < pop3.size(); i++) {
                System.out.println("\t"+pop3.get(i).continentname+"\t\t\t\t\t\t\t\t\t\t\t\t\t" + pop3.get(i).continent_pop + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + pop3.get(i).people_live_inside+"\t\t\t\t\t\t\t\t\t\t\t\t\t" + pop3.get(i).people_live_outside );
            }

        }







    /**
     * The population of people, people living in cities, and people not living in cities in each region.
     */
    public void PopRegion(Connection con){

    }

    /**
     * The population of people, people living in cities, and people not living in cities in each country.
     */
    public void PopCountry(Connection con){
 try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select country.name,Sum(country.population) as country_population,Round((SUM(city.population)/SUM(country.population)*100),3) as people_live_inside,((SUM(country.population)-SUM(city.population))/SUM(country.population*100))as people_live_outside from country join city on country.code= city.countrycode group by country.name";
            ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // create arraylist of result
            ArrayList<Population> pop = new ArrayList<Population>();
            //populate arraylist
            while (rset.next()) {
                Population pop1 = new Population();
                pop1.countryname=rset.getString("country.name");
                pop1.country_pop=  rset.getLong("country_population");
                pop1.people_live_inside= rset.getFloat("people_live_inside");
                pop1.people_live_outside= rset.getFloat("people_live_outside");
                pop.add(pop1);

            }
            if (pop == null) {
                System.out.println("Your list is empty");

            } else {
                displaysix(pop);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }
    public void displaysix(ArrayList<Population> pop3) throws InterruptedException {
        System.out.println("The population of people, people living in cities, and people not living in cities in each country.");
        System.out.println("Processing.....");
        Thread.sleep(900);
        System.out.println("\n");
        System.out.println("\tCountry_Name\t\t\t\t\t\t\t\t\t\tCountry Population\t\t\t\t\t\t\t\tPeople_Live_Inside_City\t\t\t\t\t\t\t\tPeople_Live_Outside_City");
        for (int i = 0; i < pop3.size(); i++) {
            System.out.println("\t"+pop3.get(i).countryname+"\t\t\t\t\t\t\t\t\t\t\t\t\t" + pop3.get(i).country_pop + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + pop3.get(i).people_live_inside+"\t\t\t\t\t\t\t\t\t\t\t\t\t" + pop3.get(i).people_live_outside );
        }
    }

}


