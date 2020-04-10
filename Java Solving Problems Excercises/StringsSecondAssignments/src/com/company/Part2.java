package com.company;

public class Part2 {

    public static int howMany(String stringA, String stringB) {
        int times = 0;

        while (stringB.indexOf(stringA) != -1) {
            stringB = stringB.substring(stringB.indexOf(
                    stringA)+stringA.length(),stringB.length());
            times++;
        }
        System.out.println( stringA + " aparece " + times + " veces." );
        return times;
    }

    public static void testHowMany(){
        howMany("dna", "dfgERTasddnaerrtytryrdna");
    }
}
