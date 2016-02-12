package com.rxn1d.courses;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */
public class HomeWork2String {
    /**
     * Метод должен вернуть количество четных чисел в строке.
     * <p>Например:
     * дана строка - 1_4_8_11_22, ответ - 3
     *
     * @param s строка типа число1_число2_число3_число4
     * @return количество четных числе в строке
     */
    public static int countEvenInString(String s) {
        String[] numbers = s.split("_");
        int even = 0;
        for(int i = 0; i < numbers.length; i++){
            if(Integer.valueOf(numbers[i])%2 == 0){
                even++;
            }
        }
        return even;
    }

    /**
     * Метод должен удалить указанный символ из строки (кроме случая, если
     * символ находится на первой, последней или срединной позиции)
     * <p>Например:
     * данна строка - xabxxxx, символ - x, ответ - xabx
     *
     * @param symbol символ который необходимо удалить
     * @param s      исходная строка
     * @return результирующая строка
     */
    public static String removeSymbolFromString(String symbol, String s) {
        int middle = 0;
        if(s.length()%2 == 0){
            middle = s.length()/2;
        }else{
            middle = s.length()/2+1;
        }
        String first = s.substring(0, middle);
        String second = s.substring(middle);
        char[] c1 = first.toCharArray();
        char[] c2 = second.toCharArray();
        if(c1.length > 0){
            for(int i = 1; i < (c1.length-1);){
                if(c1[i] == symbol.charAt(0)){
                    c1= ArrayUtils.remove(c1,i);
                }else{
                    i++;
                }
            }
        }
        if(c2.length > 0){
            for(int i = 0; i < (c2.length-1);){
                if(c2[i] == symbol.charAt(0)){
                    c2= ArrayUtils.remove(c2,i);
                }else{
                    i++;
                }
            }
        }
        first = String.valueOf(c1);
        second = String.valueOf(c2);
        String result = first+second;
        return result;
    }
}
