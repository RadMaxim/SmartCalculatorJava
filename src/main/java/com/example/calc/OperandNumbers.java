package com.example.calc;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OperandNumbers {
    public static double num1 = 0,num2 = 0;
    public static double result = 0;
    static char operand='+';
    public static String history = "";
    public static double getResult() throws Exception {

        switch (operand) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            case '√':
                result = Math.pow(num1, 0.5);
                break;

        }
        history = (num1 + " " + operand + " " + num2 + " = " + result);
        CreateFile.textAll.append(history).append("\n");
        CreateFile.createFile();

        return result;
    } }