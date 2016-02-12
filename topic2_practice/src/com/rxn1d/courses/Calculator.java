package com.rxn1d.courses;

/**
 * @author Ievgen Tararaka
 */
public class Calculator {
    static String[] in;
    static double res;
    public static void main(String[] args) {
        System.out.println("---> START Calculator application <---");

        // для того, чтобы читать данные из консоли спользуйте данную конструкцию
        in = ConsoleReader.readFromConsole();
        double a = Double.valueOf(in[0]);
        double b = Double.valueOf(in[2]);
        double currRes = count(a, in[1], b);
        if(in.length > 3){
            for(int i = 3; i < in.length; i+=2){
                //double temp = currRes;
                currRes = count(currRes, in[i], Double.valueOf(in[i+1]));
            }
        }
        res = currRes;
        System.out.println("Result = "+res);
        System.out.println("---> EXIT Calculator application <---");
    }
    public static double count(double a, String sign, double b){
        double temp;
        if(sign.equals("+")){
            temp = a + b;
        }else if(sign.equals("-")){
            temp = a - b;
        }else if(sign.equals("*")){
            temp = a * b;
        }else if(sign.equals("/")){
            temp = a / b;
        }else{
            temp = 0;
            System.out.println("Unknown operation");
        }
        return temp;
    }
}
