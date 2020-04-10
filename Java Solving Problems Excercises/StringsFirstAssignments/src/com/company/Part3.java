package com.company;

public class Part3 {

    public static Boolean twoOccurrences(String stringA, String stringB) {

        System.out.println("----------[Starting twoOccurrences]------------");
        if ( stringB.indexOf(stringA) != -1 ) {
            System.out.println("[INFO] - StringA se encunetra una vez dentro de StringB : " + stringB.indexOf(stringA));
            String newString = stringB.substring(stringB.indexOf(stringA) + stringA.length());
            System.out.println("[INFO] - newString : " + newString);

            if ( newString.indexOf(stringA) != -1 ) {
                System.out.println("[INFO] - StringA se encuentra por segunda vez dentro de StringB : " + newString.indexOf(stringA));
                String secondString = newString.substring(newString.indexOf(stringA) + stringA.length());
                System.out.println("[INFO] - lastString : " + secondString);
                System.out.println("----------[END]------------");

                return true;
            } else {
                System.out.println("----------[END]------------");
            }
        }
        else {
            String originalString = stringB;
            System.out.println("[INFO] - original : " + originalString);
            System.out.println("----------[END]------------");
        }
        return false;
    }

    public static void testOcurrences() {
        twoOccurrences("agt", "werasdagtrtywersdfagtert");
        twoOccurrences("agt", "werasdagtrtywersdfert");
        twoOccurrences("aiogt", "werasdagtrtywersdfert");
    }
}
