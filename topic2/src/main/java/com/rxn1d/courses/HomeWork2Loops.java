package com.rxn1d.courses;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */
public class HomeWork2Loops {
    /**
     * Метод должен вернуть минимальное число
     * из заданного массива.
     * <p>Например:
     * вернуть число=3 при заданном массиве=[5, 4, 3, 4, 5]
     *
     * @param integers заданный массив типа int[]
     * @return минимальное число из массива
     */
    public static int min(int[] integers) {
        int current = integers[0];
        for(int i = 1; i < integers.length; i++){
            if(current > integers[i]){
                current = integers[i];
            }
        }
        return current;
    }

    /**
     * Метод должен вернуть максимальное число
     * из заданного массива.
     * <p>Например:
     * вернуть число=6.0 при заданном массиве=[5.1, 4.33, 3.0, 6.0, 5.999]
     *
     * @param doubles заданный массив типа double[]
     * @return максимальное число из массива
     */
    public static double max(double[] doubles) {
        //changed return from int to double
        double current = doubles[0];
        for(int i = 1; i < doubles.length; i++){
            if(current < doubles[i]){
                current = doubles[i];
            }
        }
        return current;
    }

    /**
     * Метод должен вернуть среднее арифмитическое число
     * из заданного массива.
     * <p>Например:
     * вернуть число=8 при заданном массиве=[1, 3, 8, 10, 25, 1]
     *
     * @param shorts заданный массив типа short[]
     * @return среднее арифмитическое число из массива
     */
    public static short average(short[] shorts) {
        //changed return from int to double
        int i = 0;
        short sum = 0;
        while(i < shorts.length){
            sum +=shorts[i];
            i++;
        }
        short average = (short) (sum/shorts.length);
        return average;
    }

    /**
     * Метод должен перевернуть массив.
     * <p>Например:
     * вернуть массив=[f, e, d, c, b, a] из заданного массива=[a, b, c, d, e, f]
     *
     * @param chars заданный массив типа char[]
     * @return перевернутый массив
     */
    public static char[] reverse(char[] chars) {
        char swop1;
        char swop2;
        char temp;
        int i = 0;
        int lenght = chars.length - 1;
        do{
            swop1 = chars[i];
            swop2 = chars[lenght-i];
            //temp = swop1;
            chars[i] = swop2;
            chars[lenght-i] = swop1;
            i++;
        }while(i <= lenght/2);
        return chars;
    }
}
