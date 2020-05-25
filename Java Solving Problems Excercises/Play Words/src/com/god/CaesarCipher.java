package com.god;

public class CaesarCipher {

    public static String encrypt(String name, int key){
        StringBuilder secretName = new StringBuilder(name);
        String abcUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcLower = abcUpper.toLowerCase();
        String secretAbcLower = "";
        String secretAbcUpper = "";

        if ( key < abcLower.length()){
            secretAbcLower = abcLower.substring(key) + abcLower.substring(0,key);
            secretAbcUpper = abcUpper.substring(key) + abcUpper.substring(0,key);
        } else {
            name = "There´s no chance to encrypt.";
            return name;
        }

        int i;
        for(i=0;i<secretName.length();i++){
            //name = name.toUpperCase();
            char change = name.charAt(i);

            int abcIndexUpper = abcUpper.indexOf(change);
            int abcIndexLower = abcLower.indexOf(change);

            if (abcIndexUpper != -1) {
                char secretChange = secretAbcUpper.charAt(abcIndexUpper);
                secretName.replace(i, i + 1, String.valueOf(secretChange));
            } else if ( abcIndexLower != -1){
                char secretChange = secretAbcLower.charAt(abcIndexLower);
                secretName.replace(i, i + 1, String.valueOf(secretChange));
            }

        }

        name = secretName.toString();
        System.out.println("[info] -  encrypt : " + name);
        return name;
    }

    public static String encryptTwoKeys(String input, int key1, int key2){

        StringBuilder secretName = new StringBuilder(input);
        String abcUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcLower = abcUpper.toLowerCase();
        String secretAbcLower = "";
        String secretAbcUpper = "";
        char secretChange = 0;

        int i;
        for(i=0;i<secretName.length();i++){
            if ( key1 < abcLower.length() && key2 < abcLower.length()){

                if (i % 2 == 0){
                    secretAbcLower = abcLower.substring(key1) + abcLower.substring(0,key1);
                    secretAbcUpper = abcUpper.substring(key1) + abcUpper.substring(0,key1);
                } else {
                    secretAbcLower = abcLower.substring(key2) + abcLower.substring(0,key2);
                    secretAbcUpper = abcUpper.substring(key2) + abcUpper.substring(0,key2);
                }
            } else {
                input = "There´s no chance to encrypt.";
                return input;
            }
            //input = input.toUpperCase();
            char change = input.charAt(i);

            int abcIndexUpper = abcUpper.indexOf(change);
            int abcIndexLower = abcLower.indexOf(change);
            if (abcIndexUpper != -1) {
                secretChange = secretAbcUpper.charAt(abcIndexUpper);
                secretName.replace(i, i + 1, String.valueOf(secretChange));
            } else if ( abcIndexLower != -1){
                secretChange = secretAbcLower.charAt(abcIndexLower);
                secretName.replace(i, i + 1, String.valueOf(secretChange));
            }
        }

        input = secretName.toString();
        System.out.println("[info] -  encrypt : " + input + " =? key : "+key1 + " : " + key2);
        return input;
    }
}
