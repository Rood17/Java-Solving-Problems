package com.god;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;

public class part1 {

    public static String logInf = "[INFO] - ";
    public static String logFine = "[FINE] - ";
    private static Class<? extends DirectoryResource> File;

    public static CSVRecord coldestHourInFile(CSVParser parser) throws IOException {

        double tempF = 0;
        double maxTemp = 9999;
        CSVRecord coldParser = null;

        //Search for the coolest hour
        //TimeEST, TemperatureF, Dew PointF, Humidity, Sea Level PressureIn, VisibilityMPH, Wind Direction,
        // Wind SpeedMPH, Gust SpeedMPH, PrecipitationIn, Events, Conditions, WindDirDegrees, DateUTC
        for (CSVRecord record : parser ){
            tempF = Double.parseDouble(record.get("TemperatureF"));
            if (maxTemp > tempF && tempF != -9999) {
                maxTemp = tempF;
                coldParser = record;
            }
        }

        //System.out.println(logFine + "coldestHourInFile : " + maxTemp);
        return coldParser;
    }

    public static String fileWithColdestTemperature() throws IOException {
        String log = logInf + "fileWithColdestTemperature : ";
        String fileName = "";
        String DateUTC = "";
        String TempF = "";
        String coldestPath="";
        double tempFile = 0;
        double coldestFile = 9999;
        CSVRecord largestRecord = null;

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord recorFile = coldestHourInFile(parser);
            if (recorFile != null) {
                tempFile = Double.parseDouble(recorFile.get("TemperatureF"));
                if (coldestFile > tempFile) {
                    coldestFile = tempFile;
                    fileName = f.getName();

                    TempF = recorFile.get("TemperatureF");
                    coldestPath = f.getCanonicalPath();
                }
            } else {
                System.out.println(log + "It´s empty ");
            }
        }
        System.out.println(log + "Coldest day was in file : " + fileName);
        System.out.println(log + "Coldest temperature on that day was : " + coldestFile);
        System.out.println(log + "All the Temperatures on the coldest day were:");
        returnAllTemp(coldestPath);
        return fileName;
    }

    public static void returnAllTemp(String coldestPath) {
        String log = logInf + "returnAllTemp : ";

        FileResource fr = new FileResource(coldestPath);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser ){
            double tempF = Double.parseDouble(record.get("TemperatureF"));
            String DateUTC = record.get("DateUTC");
            System.out.println(log + DateUTC + " - " + tempF);
        }
    }

    public static CSVRecord  lowestHumidityInFile(CSVParser parser) {
        //If there is a tie, then return the first such record that was found
        //get is not “N/A”
        String log = logInf + "lowestHumidityInFile : ";
        int humi = 0;
        int lowHumi = 9999;
        String DateUTC = "";

        CSVRecord humiRecord = null;
        for (CSVRecord record : parser ){
            if (record.get("Humidity").contains( "N/A")) {
                humi = 9999;
            } else {
                humi = Integer.parseInt(record.get("Humidity"));
            }

            if (lowHumi > humi ) {
                lowHumi = humi;
                DateUTC = record.get("DateUTC");
                humiRecord = record;
            } else if (lowHumi == humi){
                lowHumi = lowHumi;
            }
        }
        System.out.println(log + "Lowest Humidity was : " + lowHumi + " at " + DateUTC);
        return humiRecord;//Lowest Humidity was 24 at 2014-01-20 19:51:00
    }

    public static CSVRecord lowestHumidityInManyFiles(){
        String log = logInf + "lowestHumidityInManyFiles : ";
        String fileName = "";
        CSVRecord humiFileRecord = null;
        String DateUTC = "";
        int humifile = 0;
        int lowHumiFile = 9999;

        DirectoryResource dr = new DirectoryResource();
        //Search for files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord recorFile = lowestHumidityInFile(parser);
            if (recorFile != null) {
                humifile = Integer.parseInt(recorFile.get("Humidity"));
                if (lowHumiFile > humifile) {
                    lowHumiFile = humifile;
                    humiFileRecord = recorFile;
                    DateUTC = recorFile.get("DateUTC");
                }
            } else {
                System.out.println(log + "It´s empty ");
            }
        }
        //Lowest Humidity was 24 at 2014-01-20 19:51:00
        System.out.println(log + "Lowest Humidity was: " + lowHumiFile + " at " + DateUTC);

        return humiFileRecord;
    }

    public static double  averageTemperatureInFile(CSVParser parser){
        double averTemp = 0;
        String log = logInf + "averageTemperatureInFile : ";
        double tempF = 0;
        double totaldata = 0;
        double sumTemp = 0;

        for (CSVRecord record : parser ){
            totaldata++;
            tempF = Double.parseDouble(record.get("TemperatureF"));
            sumTemp +=tempF;
        }

        averTemp = sumTemp / totaldata;

        System.out.println(log + "Average temperature in file is : " + averTemp);
        return averTemp;//Average temperature in file is 44.93333333333334
    }

    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        String log = logInf + "lowestHumidityInManyFiles : ";
        CSVRecord humiFileRecord = null;
        double tempF = 0;
        double sumTemp=0;
        int totaldata=0;
        double humifile = 0;
        double averTemp = 0;

       /** his method returns a double that represents the average temperature of only
        * those temperatures when the humidity was greater than or equal to value
        */
            //CSVRecord recorFile = lowestHumidityInFile(parser);
            if (parser != null) {
                for(CSVRecord record : parser) {
                    humifile = Double.parseDouble(record.get("Humidity"));
                    tempF = Double.parseDouble(record.get("TemperatureF"));
                    if ( humifile >= value) {
                        sumTemp += tempF;
                        totaldata++;
                    }
                }
            } else {
                System.out.println(log + "It´s empty ");
            }

        averTemp = sumTemp / totaldata;

        //Average Temp when high Humidity is 41.78666666666667
        if (averTemp > 0) {
            System.out.println(log + "Average Temp when high Humidity is : " + averTemp );
        }
         else {
            System.out.println(log + "No temperatures with that humidity ");
        }

        return averTemp;
    }
}

