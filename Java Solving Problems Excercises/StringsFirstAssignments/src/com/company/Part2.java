package com.company;

public class Part2 {

    //Método Público findSimpleGene
    public static String findSimpleGene (String Dna, String startCodon, String stopCodon){

        String dna = checkLowerUpperCodon(Dna);

        String result = "";
        String dnaSequence;
        int startIndex = dna.indexOf(startCodon.toLowerCase());
        int stopIndex = dna.indexOf(stopCodon.toLowerCase());

        if ( Part3.twoOccurrences(startCodon.toLowerCase(), dna)) {
            System.out.println("--------------[IT FAILS] CA REPEAT ----");
            return result;
        }

        if ( dna.indexOf(startCodon) != -1 || dna.indexOf(startCodon.toLowerCase()) != -1 ) {
            System.out.println("startCodon : " + dna.indexOf(startCodon.toLowerCase()));

            if ( dna.indexOf(stopCodon) != -1 || dna.indexOf(stopCodon.toLowerCase()) != -1 ) {
                System.out.println("stopCodon : " + dna.indexOf(stopCodon.toLowerCase()));

                dnaSequence = dna.substring(startIndex, stopIndex + 3);
                System.out.println("END CODON : " + dnaSequence );

                if ( dnaSequence.length() % 3 == 0) {
                    System.out.println("Es múltiplo");
                    result = dnaSequence;
                } else {
                    System.out.println("Fail - The string is not % = 3");
                }
            } else {
                System.out.println("Fail - There´s no TAA String.");
            }
        } else {
            System.out.println("Fail - There´s no ATG String.");
        }

        System.out.println("Result : " + result);
        System.out.println(" ----------- END ----------" );

        return result;
    }

    static void testSimpleGene() {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        findSimpleGene("QWETREATGFDSATGEFVCDWERTATT", startCodon, stopCodon);
        findSimpleGene("QWETREATGFDSEFVCDWERTTAA", startCodon, stopCodon);
        findSimpleGene("QWETREATRGFDSEFVCDWERTATTRT", startCodon, stopCodon);
        findSimpleGene("QWETREATGFDSEFVCDWERTATTTTAA", startCodon, stopCodon);
        findSimpleGene("QWETREATGFDSEFVCDWERRTRTRTRTRTRTATT", startCodon, stopCodon);
        findSimpleGene("qwesdfatgtretaa", startCodon, stopCodon);
    }

    static String checkLowerUpperCodon(String dna) {
        String codon = dna;
        String cC = dna.substring(1);
        char cCC = cC.charAt(0);
        System.out.println("Pasa Codon a ----  LoweerCase ---- " + cCC + " and _ : " + codon);
        if (Character.isUpperCase(cCC) ) {
            codon = dna.toLowerCase();
            System.out.println("Pasa Codon a ----  LoweerCase ---- " + codon);
        }

        return codon;
    }
}
