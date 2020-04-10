package com.company;

public class Part1 {

    //Método Público findSimpleGene
    public static String findSimpleGene(String Dna) {

        String dna = Dna.toUpperCase();
        String result = "";
        String dnaSequence;
        String startCodon = "ATG";
        int stopIndex;

        int startIndex = dna.indexOf(startCodon);


        if (dna.indexOf(startCodon) != -1) {
            System.out.println("[Info] - Part1 - findSimpleGene startCodon : " + dna.indexOf(startCodon));

            stopIndex = findStopCodon(dna);
            if (stopIndex != -1) {

                dnaSequence = dna.substring(startIndex, stopIndex + 3);
                System.out.println("[Info] - Part1 - findSimpleGene END CODON : " + dnaSequence);

                //If the length of the substring between the “ATG” and “TAA” is a multiple of 3,
                // then return the substring that starts with that “ATG” and ends with that “TAA”.
                if (dnaSequence.length() % 3 == 0) {
                    System.out.println("[Info] - Part1 - findSimpleGene Es múltiplo");
                    result = dnaSequence;
                } else {
                    System.out.println("[Severe] - Part1 - findSimpleGene Fail - The string is not % = 3");
                }
            } else {
                System.out.println("[Severe] - Part1 - findSimpleGene Fail - There´s no TAA String.");
            }
        } else {
            System.out.println("[Severe] - Part1 - Fail - findSimpleGene There´s no ATG String.");
        }

        System.out.println("[Fine] - Part1 - findSimpleGene Result : " + result);
        System.out.println(" ----------- END Part1 -  ----------");

        return result;
    }

    static void testSimpleGene() {
        findSimpleGene("QWETREATGFDSEFVCDWERTATT");
        findSimpleGene("QWETREATGFDSEFVCDWERTTAA");
        findSimpleGene("QWETREATRGFDSEFVCDWERTATTRT");
        findSimpleGene("QWETREATGFDSEFVCDWERTATTTTAA");
        findSimpleGene("QWETREATGFDSEFVCDWERRTRTRTRTRTRTATT");
    }

    private static int findStopCodon(String dna) {
        String stopCodonA = "TAA";
        String stopCodonB = "TAG";
        String stopCodonC = "TGA";

        int stopIndex;
        int stopIndexA = dna.indexOf(stopCodonA);
        int stopIndexB = dna.indexOf(stopCodonB);
        int stopIndexC = dna.indexOf(stopCodonC);

        if (stopIndexA != -1) {
            stopIndex = stopIndexA;
            System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + stopCodonA);
        } else if (stopIndexB != -1) {
            stopIndex = stopIndexB;
            System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + stopCodonB);
        } else {
            stopIndex = stopIndexC;
            System.out.println("[Info] - Part1 - findStopCodon - StopCodon: " + stopCodonC);
        }
        return stopIndex;
    }
}
