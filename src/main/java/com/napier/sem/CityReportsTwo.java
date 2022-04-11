package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class Description
 * This class contains the methods required to produce reports for issue #14 "City Reports 2"
 */
public class CityReportsTwo {

    /**
     * The top N populated cities in the world where N is provided by the user.
     */
    public void Display(ArrayList<City> city, int limit ){
   System.out.println("ID\t\t NAME\t\t COUNTRY\t\tDISTRICT\t\tPOPULATION");
   for(int i=0; i<limit;i++) {
    System.out.println("\t" + city.get(i).ID+"\t\t"+city.get(i).Name+"\t\t"
                        +city.get(i).countryname+"\t\t"+city.get(i).District+
            "\t\t"+city.get(i).Popluation);
   }
    }

    /**
     * The top N populated cities in a continent where N is provided by the user.
     */
    public void TopCityContinent(Connection con){

    }

    /**
     * The top N populated cities in a region where N is provided by the user.
     */
    public void TopCityRegion(Connection con){

    }

    /**
     * The top N populated cities in a country where N is provided by the user.
     */
    public void TopCityCountry(Connection con){

    }

    /**
     * The top N populated cities in a district where N is provided by the user.
     */
    public void TopCityDistrict(Connection con){

    }
}
