package com.rxn1d.courses;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */
public class HomeWork2Equation {
    /**
     * Метод должен вернуть решение квадратического уравнения.
     * <p>Например:
     * Найти решение уравнение вида 5x^2 + 2x + 11
     *
     * @param a коэфициент для x^2
     * @param b коэфициент x
     * @param c константа
     * @return решение уравнения
     */
    public static int solveEquation(int a, int b, int c) {
        int discriminant = 0;
        int x1 = 0;
        int x2 = 0;
        discriminant = b*b - 4*a*c;

        if(discriminant > 0){
            double f = (Math.sqrt(discriminant)-b)/(2*a);
            x2 = (int)(Math.sqrt(discriminant)-b)/2*a;
            x1 = (int)(-b+Math.sqrt(discriminant))/(2*a);
           // System.out.println(f);

        }
        else if(discriminant == 0){
            x1 = -b/2*a;
        }
        else{
            x1 = Integer.MIN_VALUE;
        }
        return x1;
    }
}
