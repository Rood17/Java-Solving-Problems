package com.god;

public class DecrypCypher {

    public static int sequenceLetters(String input){

        String abcLetter = "";
        String inputLetter = "";
        String lastLetter = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String largerLetter="";
        String secondLargerLetter = "";
        int largercount = 0;
        int repeatTimes = 0;
        int largercountIndex = 0;
        int secondLargerCount = 0;
        int thirdLargerCount = 0;

        int [] letterRem = new int[abc.length()];
        abc = abc.toLowerCase();

        for (int i = 0; i<abc.length();i++){
            //Search for all letters
            abcLetter =  String.valueOf(abc.charAt(i));
            for (int x = 0; x<input.length(); x++){
                inputLetter = String.valueOf(input.charAt(x));

                if (abcLetter.contains(inputLetter)){
                    if ( !lastLetter.contains(inputLetter) ){
                        //letterRem[repeatTimes] = lastLetter;
                        repeatTimes = 0;
                    }

                    repeatTimes++;
                    lastLetter = inputLetter;
                }
            }

            letterRem[i] = repeatTimes;
            repeatTimes = 0;


            //Set count array
            if ( largercount < letterRem[i]){
                largercount = letterRem[i];
                largercountIndex = i;
                largerLetter = abcLetter;
            }

            System.out.println("[INFO] - countWordLengths largercount : "  + largercount + " letter : " + largerLetter);

            secondLargerCount = largercount -1;
            //secondLargerLetter = abcLetter;
        }

        System.out.println("[FINEST] - countWordLengths largercount : "  + largercount + " letter : " + largerLetter );
        System.out.println("[FINEST] - countWordLengths secondLargerCount : "  + secondLargerCount + " secondLargerLetter : " + secondLargerLetter);
        return largercountIndex;
    }

    public static void decryptCypher(String input){
        String message = "";
        int abcLength = 26;
        CaesarCipher decryptor = new CaesarCipher();



        int largercountIndex = sequenceLetters(input) + 1;
        String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Alpha = Alpha.toLowerCase();

        //Si fuera "e"
        int eIndex = 5;
        if (largercountIndex < eIndex){
            //key = eIndex - largercountIndex;
        }

        int i = 0;
        while(i < 26 ) {
            i++;
            for (int a=1;a<=26;a++){
                message = decryptor.encryptTwoKeys(input, abcLength - i, abcLength - a);
            }
        }
    }

}
