package com.god;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class testers {
    public static void testColdestHourInFile() throws IOException {
        FileResource fr = new FileResource("C:\\Users\\rxr360\\Documents\\Java Solving Problems Excercises\\Resuerces" +
                "\\nc_weather\\2014\\weather-2014-05-01.csv");
        CSVParser parser = fr.getCSVParser();

        part1.coldestHourInFile(parser);
    }

    public static void testFileWithColdestTemperature() throws IOException {
        part1.fileWithColdestTemperature();
    }

    public static void testLowestHumidityInFile() {
        FileResource fr = new FileResource("C:\\Users\\rxr360\\Documents\\Java Solving Problems Excercises\\Resuerces" +
                "\\nc_weather\\2014\\weather-2014-04-01.csv");
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = part1.lowestHumidityInFile(parser);
    }

    public static void testLowestHumidityInManyFiles(){
        part1.lowestHumidityInManyFiles();
    }

    public static void testAverageTemperatureInFile(){
        FileResource fr = new FileResource("C:\\Users\\rxr360\\Documents\\Java Solving Problems Excercises\\Resuerces" +
                "\\nc_weather\\2014\\weather-2014-06-01.csv");
        CSVParser parser = fr.getCSVParser();
        part1.averageTemperatureInFile(parser);
    }

    public static void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource("C:\\Users\\rxr360\\Documents\\Java Solving Problems Excercises\\Resuerces" +
                "\\nc_weather\\2014\\weather-2014-03-30.csv");
        CSVParser parser = fr.getCSVParser();
        part1.averageTemperatureWithHighHumidityInFile(parser, 80);
    }
}
