package com.god;

import java.text.CharacterIterator;

public class wordPlay {
        private static String vowels = "a,e,i,o,u";

    public static boolean isVowel(char ch){
        if ( vowels.indexOf(Character.toLowerCase(ch)) != -1 ) {
            return true;
        }
        return false;
    }

    public static String replaceChar(String phrase, char ch){
        StringBuilder secretPhrase = new StringBuilder(phrase);

        int i;
        for(i=0;i<phrase.length();i++){
            char change = phrase.charAt(i);
            if(isVowel(Character.toLowerCase(change))){
                secretPhrase.replace(i, i+1, String.valueOf(ch));
            }

        }
        phrase = secretPhrase.toString();

        System.out.println("[info] - replace vowels : " + phrase);
        return phrase;
    }

    public static String emphasize(String phrase, char ch){
        StringBuilder secretPhrase = new StringBuilder(phrase);
        int i;
        for(i=0;i<phrase.length();i++){
            char change = phrase.charAt(i);
            if(isVowel(Character.toLowerCase(change))){
                if(i % 2 == 0){
                    secretPhrase.replace(i, i+1, String.valueOf('+'));
                } else {
                    secretPhrase.replace(i, i+1, String.valueOf(ch));

                }
            }

        }
        phrase = secretPhrase.toString();
        System.out.println("[info] -  emphasize : " + phrase );
        return phrase;
    }
}
