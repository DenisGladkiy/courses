package com.rxn1d.courses;

/**
 * Created by Denis on 11.02.2016.
 */
public class Test {
    public static void main(String[] args){
        testEquation(5, 200, 1);
        int[] testMinArr = {15,11,5,6,8,3,18,0,9};
        testMinValue(testMinArr);
        double[] testMaxArr = {18.3, 1.5, 2.8, 14.6, 0.3, 0.13, 15.9};
        testMaxValue(testMaxArr);
        short[] testAverArr = {3,5,6,1,2};
        testAverage(testAverArr);
        char[] testRevArr = {'a','b','c','d','e','f','g','h'};
        testReverse(testRevArr);
        String test = "1_4_6_9_100_101_104";
        testString(test);
        testRemoveSymbol("x","axxa");
    }

    private static void testEquation(int a, int b, int c){
        int x;
        x = HomeWork2Equation.solveEquation(a, b, c);
        if(x == Integer.MIN_VALUE){
            System.out.println("Equation doesn't have solution");
        }
        else {
            System.out.println("Equation x= "+x);
        }
    }
    private static void testMinValue(int[] array){
        int min = HomeWork2Loops.min(array);
        for(int i = 0; i<array.length; i++){
            System.out.print("\b"+array[i]);
        }
        System.out.println("\n"+"Min value from arr = "+min);
    }
    private static void testMaxValue(double[] array){
        double max = HomeWork2Loops.max(array);
        for(int i = 0; i<array.length; i++){
            System.out.print("\b"+array[i]);
        }
        System.out.println("\n"+"Max value from arr = "+max);
    }
    private static void testAverage(short[] array){
        double average = HomeWork2Loops.average(array);
        for(int i = 0; i<array.length; i++){
            System.out.print("\b"+array[i]);
        }
        System.out.println("\n"+"average = "+average);
    }
    private static void testReverse(char[] array){
        HomeWork2Loops.reverse(array);
        for(int i = 0; i<array.length; i++){
            System.out.print("\b"+array[i]);
        }
        System.out.println("\n");
    }
    private static void testString(String s){
        System.out.println(HomeWork2String.countEvenInString(s));
    }
    private static void testRemoveSymbol(String symbol, String word){
        String res = HomeWork2String.removeSymbolFromString(symbol,word);
        System.out.println("Word - "+word+"; remove symbol - "+symbol+"; Result - "+res);
    }
}
