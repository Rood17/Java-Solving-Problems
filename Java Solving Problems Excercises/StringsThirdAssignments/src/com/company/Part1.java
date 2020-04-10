package com.company;

import java.util.ArrayList;


public class Part1 {

    public static ArrayList allGenes = new ArrayList();
    private static String mayor;
    public static  int countCTG = 0;
    public static  int totalGenes = 0;
    public static  int mayo60 = 0;

    public static String findSimpleGene(String dna, String stopCodon) {

        String dnaSequence = "";
        String result = "";
        int startIndex = dna.length();
        int newStartIndex=-1;
        int oldStartIndex=-1;
        boolean startCPAss = false;

        //Search for StartCodon
        startIndex = findStartCodon(dna);

        //If there´s no stopcodon, serahc for a new startcodon
        while (dnaSequence == "" ) {
            if (startCPAss) {
                newStartIndex = findStartCodon(dna, startIndex + oldStartIndex);
            } else {
                newStartIndex = findStartCodon(dna, startIndex);
            }
            if ( newStartIndex != -1 ){
                dnaSequence = findStopCodon(dna, newStartIndex,stopCodon);
            } else {
                break;
            }
            if (dnaSequence != "") {
                break;
            } else {
                startCPAss = true;
                oldStartIndex +=newStartIndex;
            }
        }

        result = dnaSequence;
        System.out.println("[FINE] - ------------END ON EXECUTE FIND SIMPLE GENE ---------" );
        return result;
    }

    public static int findStartCodon(String dna) {
        String startCodon = "ATG";
        int startIndex = dna.indexOf(startCodon);
        int result;
        //System.out.println("[Info] - findStopCodon - startCodon: " + startIndex);
        result = startIndex;
        return result;
    }

    //@overload
    public static int findStartCodon(String dna, int oldStartIndex) {
        String startCodon = "ATG";
        String startDna;
        int newStartIndex = -1;
        int result = -1;

        //Search after startCodon
        if (dna.length() > oldStartIndex+3) {
            startDna = dna.substring(oldStartIndex+3);
            newStartIndex = startDna.indexOf(startCodon);
        }

        if (newStartIndex != -1) {
            result = newStartIndex + oldStartIndex +3;
           // System.out.println("[Info] - findStartCodon - newStartIndex: " + newStartIndex + oldStartIndex +3);
        }
        return result;
    }

    public static String findStopCodon(String completeDna, int startIndex, String stopCodon) {

        String stopCodonA = stopCodon;
        String dnaSequence = "";
        String dna;
        String startDna;
        boolean dna3 = false;
        int oldStopIndex = 0;

        //Search after startCodon
        startDna = completeDna.substring(startIndex);
        dna = completeDna.substring(startIndex);

        //Search %3 Codoms
        while ( dnaSequence == "" ) {
            //Search for the stopCodon
            int stopIndex = -1;
            if (dna.indexOf(stopCodonA) != -1) {
                stopIndex = dna.indexOf(stopCodonA);
                //System.out.println("[INFO] - findStopCodon - stopCodonA 1 : " + stopCodonA);
                //System.out.println("[INFO] - findStopCodon - stopIndex  : " + stopIndex);
            }

            //Search for dnaSequence
            if (stopIndex != -1) {
                if (dna3) {
                    dnaSequence = dnaSequence(0, stopIndex + oldStopIndex, startDna + oldStopIndex);
                } else {
                    dnaSequence = dnaSequence(0, stopIndex, startDna);
                }
                //System.out.println("[INFO] - findStopCodon - stopCodonD 4 : " + stopIndex);
                if (dnaSequence != "") {
                    break;
                } else {
                    dna = dna.substring(stopIndex+3);
                    oldStopIndex += stopIndex+3;
                    dna3 = true;
                    //System.out.println("[FINE] - findStopCodon - oldStopIndex  : " + oldStopIndex);
                }
            } else {
                //aquí se pued eprobar con otro startcodon
                System.out.println("[SEVERE] - findStopCodon Fail - There´s no stopCodon String.");
                break;
            }
        }

        //System.out.println("[FINE] - findStopCodon - dnaSequence %3 : " + isMultOf3(dnaSequence));
        return dnaSequence;
    }

    public static <allGenes> ArrayList getAllGenes(String dna) {
        int dnaIndex;
        String gene;
        String newDnaString;
        dna = dna.toUpperCase();
        int geneNum = 1;
        int laps = 0;

        //StopCodon
        String stopCodon = "TAA";

        //countCTG(dna);
        countCTG = countCTG(dna);

        System.out.println(" ****  GET ALL GENES ****" );
        while ( dna.length() != 0 ) {
            System.out.println("[INFO] - ** -   getAllGenes- ** length " + dna.length() );
            System.out.println("[INFO] - ** -   getAllGenes- ** laps " + laps++ );
            gene = findSimpleGene(dna, stopCodon);
            if (gene.length() != 0 && gene != "-1") {
                geneNum++;

                dnaIndex = dna.indexOf(gene);
                dna = dna.substring(dnaIndex + gene.length());

                allGenes.add(gene);


                System.out.println("[INFO] - GENE : " + gene);

            } else {
                break;
            }
            System.out.println("[INFO] - allGenes : " + allGenes );
            System.out.println("" );
        }

        totalGenes = allGenes.size();
        System.out.println("[FINE] - allGenes Complete : " + allGenes );
        System.out.println("[FINE] ----------------------------END FIND ALL GENES ------------------------------------------- " );
        System.out.println("" );
        return allGenes;
    }

    public static float cgRatio ( String dna) {
        int result = 0;
        char cSearch = 'G';
        char gSearch = 'G';
        int cCount = 0;
        int gCount = 0;
        int cIndex = 0;
        int gIndex = 0;
        String firstDna = dna;
        int dnaLength = dna.length();

        System.out.println("" );
        System.out.println("[INFO] - ** - START PROGRAM cgRatio - ** " );
        System.out.println("[INFO] - cgRatio - DNA : " + dna);
        //Searching for "C"
        while( dnaLength > 0){
                cIndex = dna.indexOf(cSearch);
                dna = dna.substring(cIndex + 1);
                cCount++;
            if (dna.indexOf(cSearch) == -1){
                break;
            }
        }

        //Searching for "G"
        while( dnaLength > 0){
            gIndex = dna.indexOf(gSearch);
            dna = dna.substring(gIndex + 1);
            gCount++;
            if (dna.indexOf(gSearch) == -1){
                break;
            }
        }

        System.out.println("[INFO] - cgRatio - cCount in dna : " + cCount);
        System.out.println("[INFO] - cgRatio - gCount in dna : " + gCount);

        //Generate Ratio
        int totalCG = (gCount + cCount);
        result = dnaLength/totalCG;

        return result;
    }

    public static int countCTG(String dna) {
        int dnaLength = dna.length();
        String ctgSearch = "CTG";
        int ctgIndex = 0;
        int ctgCount = 0;

        System.out.println("" );
        System.out.println("[INFO] - ** - START PROGRAM COUNT CTG - ** " );
        System.out.println("[INFO] - cgRatio - DNA : " + dna);
        //Searching for "G"
        if (dna.indexOf(ctgSearch) == -1){
            ctgCount = 0;
        } else {
            while( dnaLength > 0){
                ctgIndex = dna.indexOf(ctgSearch);
                dna = dna.substring(ctgIndex + 1);
                ctgCount++;
                if (dna.indexOf(ctgSearch) == -1){
                    break;
                }
            }
        }

        System.out.println("[INFO] - ctgCount - ctgCount in dna : " + ctgCount);
        return ctgCount;
    }

    public static void processGenes(ArrayList sR){
        float cgRatioMin = (float) 0.35;
        ArrayList successGenes = new ArrayList();

        //print all the Strings in sr that are longer than 9 characters
        for (int i=0; i < sR.size(); i++) {
            //Check Gene Length
            if (sR.get(i).toString().length() >= 9){
                System.out.println("[INFO] - processGenes - Gene > 9 : " + sR.get(i) );
                int equenceLnegth = sR.get(i).toString().length();
                if ( equenceLnegth > 60) {
                    mayo60 += 1;
                }

                //Check CG RATIO
                float cgRatioTest = cgRatio(sR.get(i).toString());
                if ( cgRatioTest > cgRatioMin ) {
                    System.out.println("[INFO] - processGenes - cgRatio : " + sR.get(i) );
                    successGenes.add(sR.get(i));
                }
            }

        }


        System.out.println("[FINAL] - processGenes - lONGEST GENE  : " + longestGene(sR));
        System.out.println("[FINAL] - processGenes - lONGEST GENE LENGTH : " + longestGene(sR).length());
        System.out.println("[FINAL] - processGenes - mayo60  : " + mayo60);
        System.out.println("[FINAL] - processGenes - totalGenes  : " + totalGenes);
        System.out.println("[FINAL] - processGenes - successGenes  : " + successGenes);
        System.out.println("[FINAL] - processGenes - successGenes LENGTH  : " + successGenes.size());
        System.out.println("[FINAL] - processGenes - countCTG  : " + countCTG);

    }

    public static String longestGene(ArrayList gene) {
        String result = "Ups.. There´s something wrong.";

        System.out.println("" );
        System.out.println("[INFO] - ** - START PROGRAM longestGene - ** " );
        System.out.println("[INFO] - longestGene - DNA : " + gene);

        for( int i = 0; i<gene.size(); i++) {
            if ( i == 0 ) {
                mayor = gene.get(0).toString();
            }

            if (gene.get(i).toString().length() > mayor.length()) {
                mayor = gene.get(i).toString();//Se settea al mayor
            } else {
                if ( gene.get(i).toString().length() <= mayor.length()) {
                    mayor = mayor;//Se queda igual
                }
            }
        }

        if ( mayor != null ){
            System.out.println("");
            //System.out.println("[FINAL] - The longest gene is : " + mayor );
            //System.out.println("[FINAL] - with a length of : " + mayor.length());
            result =  mayor;
        }
        System.out.println(" ");
        return result;
    }

    public static String dnaSequence(int startIndex, int stopIndex, String dna) {
        String dnaSequence;
        String result = "-1";
        boolean pass;

        //Search for the sequuencE
        dnaSequence = dna.substring(startIndex, stopIndex + 3);
        pass = isMultOf3(dnaSequence);
        if (pass){
            result = dnaSequence;
        } else {
            result = "";
        }

        //Return DNA SEQUENCE
        System.out.println("[FINE] - findSimpleGene dnaSequence : " + result);
        return result;
    }
    public static  boolean isMultOf3(String dnaSequence) {
        if (dnaSequence.length() % 3 == 0) {
            return true;
        }
        return false;
    }

    public static void testProcessGenes(){
        processGenes(allGenes);
    }

}