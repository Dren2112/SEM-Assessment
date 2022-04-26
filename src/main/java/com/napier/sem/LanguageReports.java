package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #19 "Language Reports"
 */
public class LanguageReports {
    // A METHOD FOR THE TEST QUERY
    public void Test(Connection con) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name FROM city WHERE ID = 1 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next()) {
                System.out.println(rset.getString("Name"));
                // system should output Kabul as result
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }


    /**
     *  the organisation has asked if it is possible to provide the number of people who speak
     *  the following languages from greatest number to smallest, including the percentage
     *  of the world population:
     *
     * Chinese.
     * English.
     * Hindi.
     * Spanish.
     * Arabic.
     */
    public ArrayList<Language> LanguageReport(Connection con, int limit){
        try {
            //Create an SQL Statement
            Statement stmt = con.createStatement();
            //Create string for the SQL Statement
            String strSelect =
                    "SELECT Language, SUM(Percentage*Population/100) AS 'Total Speakers', SUM(Percentage*Population/100)/(SELECT SUM(Population) AS 'World Population' FROM country)*100 AS 'Percentage of World' FROM countrylanguage INNER JOIN country c ON countrylanguage.CountryCode = c.Code WHERE (Language = 'Chinese' AND Percentage > 0) OR (Language = 'English' AND Percentage > 0) OR (Language = 'Hindi' AND Percentage > 0) OR (Language = 'Spanish' AND Percentage > 0) OR (Language = 'Arabic' AND Percentage > 0) GROUP BY Language ORDER BY `Total Speakers` DESC;";

            //Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Create Arraylist out of the result
            ArrayList<Language> world = new ArrayList<>();
            //Populate Arraylist
            while(rset.next()) {
                    Language languages = new Language();
                    languages.language = rset.getString("Language");
                    languages.Speakers = rset.getLong("Total Speakers");
                    languages.Percentage = rset.getFloat("Percentage of World");

                    world.add(languages);
            }

            //Send Arraylist to Output
            output(world);

            return world;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

            return null;
        }

    }




    public void output(ArrayList<Language> contents) {

        if (contents == null) {
            System.out.println("No Data Found");
        }
        else {
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("Language                ||              Total Speakers              ||             Percentage of World");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < contents.size(); i++) {

                        
                        String strLang = String.format("%-43s", contents.get(i).language);
                        String strSpeak = String.format("%-50s", contents.get(i).Speakers);
                        String strPercent = String.format("%-18s", contents.get(i).Percentage);

                        System.out.println(strLang + strSpeak + strPercent);
            }
        }
    }


}
