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
    public void PopContinent(Connection con ,int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "Select country.continent,SUM(city.population), Sum(country.population) from country join city on city.countrycode= country.code where country.continent='Asia' ";
         //   String strselect1="Select Sum(city.population)  from country join city on city.countrycode=country.code where continent='Asia' And SUM(city.population)-SUM(country.population)";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
           // ResultSet rset1= stmt.executeQuery(strselect1);

            // create arraylist of result
            ArrayList<Population> pop = new ArrayList<Population>();
            //populate arraylist
            while (rset.next()) {
                Population pop1 = new Population();
                pop1.continentname=rset.getString("country.continent");
                pop1.people_live_inside = rset.getInt("SUM(city.population)");
           //    pop1.people_live_outside = BigInteger.valueOf(rset.getInt("SUM(country.population)"));

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
            System.out.println("All the cities in specified region organsied by largest population to smallest");
            System.out.println("Processing.....");
            Thread.sleep(900);
            System.out.println("\n");
            System.out.println("\tcity pop\t\t\t\t\t\t\tcountry pop");
            for (int i = 0; i < pop3.size(); i++) {
                System.out.println("\t"+pop3.get(i).continentname+"\t\t\t\t\t\t\t\t" + pop3.get(i).people_live_inside + "\t\t\t\t\t\t\t" + pop3.get(i).people_live_outside );
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

    }

}
