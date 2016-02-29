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
        middle = (s.length()/2);
        char[] word = s.toCharArray();
        for(int i = 1; i < word.length - 1; i++){
            if (i != middle && word[i] == symbol.charAt(0)){
                word = ArrayUtils.remove(word, i);
                i--;
                middle--;
            }
        }
        String result = String.valueOf(word);
        return result;
    }
}
