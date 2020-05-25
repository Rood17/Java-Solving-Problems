package com.god;

import java.io.IOException;

public class testers {
    public static void testTotalotalBirths() throws IOException {
        Part1.totalBirths();
    }

    public static void testGetRank(){
        String name = "Frank";
        String gendre = "M";
        int year = 1971;
        Part1.getRank(year, name, gendre);
    }

    public static void testGetName(){
        int rank = 450;
        String gendre = "M";
        int year = 1982;
        Part1.getName(year, rank, gendre);
    }

    public static void testWwhatIsNameInYear(){
        String name = "Susan ";
        String gender = "F";
        int year = 1972;
        int newYear = 2014;

        Part1.whatIsNameInYear(name, year, newYear, gender);
    }

    public static void testYearOfHighestRank(){
        String name = "Genevieve";
        String gender = "F";

        Part1.yearOfHighestRank(name, gender);
    }

    public static void testGetAverageRank(){
        String name = "Robert";
        String gender = "M";

        Part1.getAverageRank(name, gender);
    }

    public static void getTotalBirthsRankedHigher(){
        String name = "Emily";
        String gender = "F";
        int year = 1990 ;

        Part1.getTotalBirthsRankedHigher(year, name, gender);
    }
}
