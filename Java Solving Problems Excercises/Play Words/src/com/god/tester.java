package com.god;

import edu.duke.FileResource;

public class tester {
    public static void testIsVowel(){
        boolean result = wordPlay.isVowel('u');
    }

    public static void testReplaceChar(){
       //wordPlay.replaceChar("parangaricutimiricuaro sal sallallalala", '*');
        //wordPlay.emphasize("parangaricutimiricuaro sal sallallalala", '*');
        CaesarCipher.encryptTwoKeys("Hola Ili cómo está, ",8, 21);
        //CaesarCipher.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
    }

    public static void testCaesar(){
        int key = 23;

        FileResource fr = new FileResource();
        String message = fr.asString();

        String encrypted = CaesarCipher.encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    public static void testCountWordLengths(){
        FileResource resource = new FileResource("C:\\Users\\rxr360\\Documents\\Java Solving Problems Excercises" +
                "\\Resuerces\\words\\test.txt");
        int[] count = new int[wordLength.fileWordCommons(resource)];;
        wordLength.countWordLengths(resource, count);
    }

    public static void testSequenceLetter(){
        DecrypCypher.sequenceLetters("www a Jrr ee x s fffffff");

    }

    public static void testFinal6(){
        DecrypCypher.decryptCypher("Just a test string with lots of eeeeeeeeeeeeeeeees");
        CaesarCipher.encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees", 14, 18);

    }
    public static void testFina6(){
        DecrypCypher.decryptCypher("Just a test string with lots of eeeeeeeeeeeeeeeees");
        //14 18 - 12 8 ------------------------------------------------------------------------------- 14 -26       18 -26
        CaesarCipher.encryptTwoKeys("Xmgl s lskh glfaby owlv zghk gt swswswswswswswswsk", 12, 8);
    }
}
