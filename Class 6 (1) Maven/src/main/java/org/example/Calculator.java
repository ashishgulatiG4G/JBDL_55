package org.example;

public class Calculator {
    public static void main(String[] args) throws Exception {
        int a = 2;
        int b = 10;




        int oper = 4;
        int result = 0;
        if(oper == 0) {
           // add operation
            result = org.calculator.Main.add(a, b);

        } else if(oper == 1) {
            // subtract operation
            result =org.calculator.Main.add(a, b);
        } else if(oper == 2) {
            result =org.calculator.Main.add(a, b);
            //multiply
        } else if(oper == 3) {
            result =org.calculator.Main.add(a, b);
            // divide
        } else if(oper == 4) {
            result = org.calculator.Main.power(a, b);
        }
         else {
            throw new Exception("Invalid operation");
        }

        System.out.println(result);
    }



}
