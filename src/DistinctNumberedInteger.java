package com.olabilemez.guesswhat;

import java.util.Random;

/**
 * Created by olabilemez on 2/25/2015.
 */
public class DistinctNumberedInteger {

    public static boolean doesDigitHolds(int digitNum , String number){
        return digitNum == number.length();
    }


    public static boolean isDistinct(String number){
        boolean result = true;
        final int digit = number.length();
        for (int i = 0 ; i < digit ; i++){
            for (int j = 0 ; j < digit ; j++){
                if ((number.charAt(i) == number.charAt(j)) && i != j  ){
                    result = false;
                }
            }
        }
        return result;
    }

    public static int randomizeDifferent(int digit){
        Random random = new Random();
        String tryThis = new String("");

        while(true){
            for (int i = 0 ; i < digit ; i++){
                tryThis += Integer.toString(random.nextInt(9)+1);
            }
            if (isDistinct(tryThis))break;
            else{
                tryThis = "";
            }
        }

        return Integer.parseInt(tryThis) ;
    }
}
