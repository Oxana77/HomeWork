package com.oxana;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------Task 1----------------");
        CheckEvenNumbers(11);
        System.out.println("-------------Task 2----------------");
        OutClosestTenValue(12.8,7.2);
        System.out.println("-------------Task 3----------------");
        int randomNumber = RandomInt(100, 999);
        System.out.println("Random number is - " + randomNumber);
        System.out.println("Biggest numeral is - " + BiggestNumeral(randomNumber));

    }

    public static void CheckEvenNumbers(int number){
        if (number%10 == 0){
            System.out.println(number + " - is even number");
        }
        else {
            System.out.println(number + " - is odd number");
        }
    }

    public static void OutClosestTenValue(double n, double m){
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        MathContext context = new MathContext(8, RoundingMode.HALF_UP);
        BigDecimal mDistance = new BigDecimal(abs(m - 10)).round(context);
        BigDecimal nDistance = new BigDecimal(abs(n - 10)).round(context);

        if (nDistance.compareTo(mDistance) > 0 ){
            System.out.println(m + " - is closer to 10");
        }
        else if (nDistance.compareTo(mDistance) < 0 ){
            System.out.println(n + " - is closer to 10");
        }
        else {
            System.out.println("n and m have the same distance to 10");
        }
    }

    public static int RandomInt(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    public static int BiggestNumeral(int number){
        String temp = Integer.toString(number);
        int[] intArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            intArray[i] = temp.charAt(i) - '0';
        }

        return Arrays.stream(intArray).max().getAsInt();
    }
}
