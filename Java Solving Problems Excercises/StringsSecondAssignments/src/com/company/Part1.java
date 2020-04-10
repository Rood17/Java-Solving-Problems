package com.company;

import java.util.function.DoubleToIntFunction;

public class Part1 {
    public static String findSimpleGene(String dna) {

        String dnaSequence;
        String newDnaSequence;
        String result = "";
        int stopIndex;
        int startIndex = dna.length();


        startIndex = findStartCodon(dna);
        if (startIndex != -1) {

            stopIndex = findStopCodon(dna, startIndex);
            if (stopIndex != -1) {
                dnaSequence = dna.substring(startIndex, stopIndex + 3);
                result = dnaSequence;
            }
        }
        //System.out.println("[FINE] - Part1 - ------------EXECUTE FIND SIMPLE GENE ---------");
        return result;
    }

    public static int findStartCodon(String dna) {
        String startCodon = "ATG";
        int startIndex = dna.indexOf(startCodon);
        int result;
        //System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + startCodon);
        result = startIndex;
        return result;
    }

    public static int findStopCodon(String dna, int startIndex) {

        String stopCodonA = "TAA";
        String stopCodonB = "TAG";
        String stopCodonC = "TGA";

        int stopIndex = -1;
        int stopIndexA = dna.indexOf(stopCodonA);
        int stopIndexB = dna.indexOf(stopCodonB);
        int stopIndexC = dna.indexOf(stopCodonC);

        int result;

        if (dna.length() % 3 == 0) {
            if (stopIndexA != -1) {
                stopIndex = stopIndexA;
                //System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + stopCodonA);
            } else if (stopIndexB != -1) {
                stopIndex = stopIndexB;
               // System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + stopCodonB);
            } else if ( stopIndexC != -1 ) {
                stopIndex = stopIndexC;
                //System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + stopCodonC);
            } else {
                System.out.println("[Severe] - Part1 - findStopCodon Fail - There´s no stopCodon String.");
            }
        } else {
            System.out.println("[Severe] - Part1 - findStopCodon Fail - The string is not % = 3");
        }

        result = stopIndex;
        return result;
    }

    public static void findAllGenes(String dna) {
        int dnaIndex;
        String gene;
        String newDnaString;
        int geneNum = 1;

        while ( dna.length() != 0 ) {
            //Quiero que busques en la secuencia dada si existe un gen,
            gene = findSimpleGene(dna);
            if (gene.length() != 0 ) {
                geneNum++;

                dnaIndex = dna.indexOf(gene);
                dna = dna.substring(dnaIndex + gene.length());

                System.out.println("[FINE] - Part1 - GENE : " + gene);
                if (dna.length() > 6) {
                    gene = findSimpleGene(dna);
                } else {
                    break;
                }
            } else {
                break;
            }
            //System.out.println("[FINE] - Part1 - geneNum : " + geneNum );
        }
        System.out.println("[FINE] ----------------------------END FIND ALL GENES ------------------------------------------- " );
    }

}