package com.god;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class wordLength {

    public static String[] getCommons(FileResource resource){
        String[] common = new String[fileWordCommons(resource)];

        int i = 0;
        for (String s : resource.words()){
            i++;
            common[i] = s;
        }

        return common;
    }

    public static int fileWordCommons(FileResource resource){
        int wordsLength = 0;

        for (String s : resource.words()){
            wordsLength++;
        }

        return wordsLength;
    }

    public static void countWordLengths(FileResource file, int[] counts){

        String exceptions = "-";
        String toQuit = ":";
        String largerWord = "";
        int largercount = 0;
        int i = 0;

        for (String k : file.words()) {
            i++;
            //Remove unlike characters
            for ( int x = 0; x < k.length(); x++){
                char letter = k.charAt(x);
                if ( !Character.isLetter(letter) ){
                    if(!exceptions.contains(String.valueOf(letter)) || toQuit.contains(String.valueOf(letter))) {
                        k = k.replace(String.valueOf(letter), "");
                    }
                }
            }
            //Set count array
            counts[i-1] = k.length();
            if(largercount <= k.length()){
                largercount = counts[i-1];
                largerWord = k;
            }
            System.out.println("[INFO] - countWordLengths WORD : " + k + " - LENGTH : " + counts[i-1]);
        }
        System.out.println("[INFO] - countWordLengths largerWord : "  + largerWord);
    }
}
