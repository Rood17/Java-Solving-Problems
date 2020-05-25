package com.god;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;

public class Part1 {
    public static void totalBirths() throws IOException {
        String log = "[INFO] - totalBirths : ";
        String name = "";
        String gendre = "";
        int hommeCount = 0;
        int femmeCount = 0;
        int cant = 0;
        int totalCount=0;

        //(shown in the video for this project) to also print the number of girls names ,
        // the number of boys names and the total names in the file.
        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            if( parser != null ){
                for ( CSVRecord rec : parser ){
                    name = rec.get(0);
                    gendre = rec.get(1);
                    cant = Integer.parseInt(rec.get(2));
                    totalCount++;

                    if(gendre.contains("M")){
                        hommeCount++;
                    } else {
                        femmeCount++;
                    }
                }
            } else {
                System.out.println(log + "Parser is null");
            }
        }
        System.out.println(log + "totalCount : " + totalCount);
        System.out.println(log + "hommeCount : " + hommeCount);
        System.out.println(log + "femmeCount : " + femmeCount);
    }

    public static int getRank(int year, String name, String gender){
        String log = "[INFO] - getRank : ";
        int totalRank = 0;
        int femmeRank = 0;
        int maleRank = 0;
        int stopRank=-1;
        String fileName= "";

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            if(f.getName().contains(Integer.toString( year ))){
                fileName = f.getName();
                FileResource fr = new FileResource(f);
                CSVParser parser = fr.getCSVParser(false);

                for (CSVRecord rec : parser) {
                    totalRank++;
                    //Rank for Femme
                    if(rec.get(1).contains("F")){
                        femmeRank++;
                        if (rec.get(0).contains(name) && rec.get(1).contains(gender)) {
                            stopRank = femmeRank;
                        }
                    }else {
                        maleRank++;
                        if (rec.get(0).contains(name) && rec.get(1).contains(gender)) {
                            stopRank = maleRank;
                        }
                    }
                }
            } else {
                System.out.println(log + "getRank - There no match with the year : " + year);
            }
        }

        //return rank
        System.out.println(log + "getRank : " + stopRank );
        return stopRank;
    }

    public static String getName(int year, int rank, String gender){
        String resultName = "NO NAME";
        String log = "[INFO] - getName : ";
        int totalRank = 0;
        int femmeRank = 0;
        int maleRank = 0;
        int stopRank=-1;
        String fileName= "";

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            if (f.getName().contains(Integer.toString(year))) {
                fileName = f.getName();
                FileResource fr = new FileResource(f);
                CSVParser parser = fr.getCSVParser(false);

                for (CSVRecord rec : parser) {
                    totalRank++;
                    //Rank for Femme
                    if (rec.get(1).contains("F")) {
                        femmeRank++;
                        if (femmeRank == rank && rec.get(1).contains(gender)) {
                            resultName = rec.get(0);
                        }
                    } else {
                        maleRank++;
                        if (maleRank == rank && rec.get(1).contains(gender)) {
                            resultName = rec.get(0);
                        }
                    }
                }
            }
        }

        System.out.println(log + "resultName : " + resultName);
        return resultName;
    }

    public static String getName(int rank, String gender, CSVParser parser){
        String resultName = "NO NAME";
        String log = "[INFO] - getName : ";
        int totalRank = 0;
        int femmeRank = 0;
        int maleRank = 0;
        int stopRank=-1;
        String fileName= "";

        for (CSVRecord rec : parser) {
            totalRank++;
            //Rank for Femme
            if (rec.get(1).contains("F")) {
                femmeRank++;
                if (femmeRank == rank && rec.get(1).contains(gender)) {
                    resultName = rec.get(0);
                }
            } else {
                maleRank++;
                if (maleRank == rank && rec.get(1).contains(gender)) {
                    resultName = rec.get(0);
                }
            }
        }

        System.out.println(log + "resultName : " + resultName);
        return resultName;
    }

    public static int getRank(String name, String gender, CSVParser parser){
        String log = "[INFO] - getRank : ";
        int totalRank = 0;
        int femmeRank = 0;
        int maleRank = 0;
        int stopRank=-1;
        String fileName= "";


        for (CSVRecord rec : parser) {
            totalRank++;
            //Rank for Femme
            if(rec.get(1).contains("F")){
                femmeRank++;
                if (rec.get(0).contains(name) && rec.get(1).contains(gender)) {
                    stopRank = femmeRank;
                }
            }else {
                maleRank++;
                if (rec.get(0).contains(name) && rec.get(1).contains(gender)) {
                    stopRank = maleRank;
                }
            }
        }

        //return rank
        //System.out.println(log + "getRank : " + stopRank );
        return stopRank;
    }

    public static void whatIsNameInYear(String name, int year, int newYear, String gender){
        String log = "[INFO] - whatIsNameInYear : ";
        String newName = "";
        String fileName;

        int rank = getRank(year, name, gender);
        newName = getName(newYear, rank,gender);

        //Isabella born in 2012 would be Sophia if she was born in 2014.
        System.out.println(log + name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
    }

    public static int yearOfHighestRank(String name, String gender){
        int year=0;
        int rank = 0;
        int highRank = 0;
        String childs = "";
        String fileName;
        String log = "[INFO] - yearOfHighestRank : ";

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            fileName = f.getName();
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);

            for (CSVRecord rec : parser) {

                if (rec.get(0).contains(name) && rec.get(1).contains(gender)){
                    fileName = f.getName();
                    year = Integer.parseInt(fileName.substring(fileName.length() -8 ,fileName.length()-4));
                    childs = rec.get(2);
                    System.out.println(log + "highRank : " + highRank + " at " + year );
                    rank = getRank(name, gender, parser);
                }
            }

            if(highRank < rank){
                highRank = rank;

            }
        }

        //returns an integer, the year with the highest rank for the name and gender.
        System.out.println(log + "highRank : " + highRank + " at " + year );
        return highRank;
    }

    public static double getAverageRank(String name, String gender){
        int year=0;
        int rank = 0;
        double sumRank = 0;
        double totalRanks = 0;
        double averageRank = -1;
        String log = "[INFO] - getAverageRank : ";

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);

            for (CSVRecord rec : parser) {
                if (rec.get(0).contains(name) && rec.get(1).contains(gender)) {
                    rank = getRank(name, gender, parser);
                    if(rank != -1){
                        sumRank += rank;
                        totalRanks++;
                    }
                }
            }
        }
        averageRank = sumRank / totalRanks;
        System.out.println(log + "Average Ranks for " + name + " : " + averageRank);
        return averageRank;
    }

    public static int getTotalBirthsRankedHigher(int year, String name, String gender){
        /**
         * returns an integer, the total number of births of those names with the same gender and same year
         * who are ranked higher than name. For example, if getTotalBirthsRankedHigher accesses the "yob2012short.csv"
         * file with name set to “Ethan”, gender set to “M”, and year set to 2012, then this method should return 15, s
         * ince Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan.
         */
        int totalBirths = -1;
        int rank = 0;
        int i = 0;
        double sumRank = 0;
        double totalRanks = 0;
        double averageRank = -1;
        String log = "[INFO] - getAverageRank : ";

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            if (f.getName().contains(Integer.toString(year))) {
                CSVParser parser = fr.getCSVParser(false);

                for (CSVRecord rec : parser) {
                    if ( rec.get(1).contains(gender))
                    {
                        if (rec.get(0).contains(name)){
                            totalBirths += 1;
                            System.out.println(log + "Total births up " + totalBirths );
                            return totalBirths;
                        }
                        totalBirths += Integer.parseInt(rec.get(2));
                        System.out.println(log + "Total births up " + rec.get(2) );

                    }
                }
            } else {
                System.out.println(log + "There´s no name in year");
            }

        }
        System.out.println(log + "Total births up" + totalBirths );
        //15, since Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan.

        return  totalBirths;
    }
}
