package com.example.calc;

import java.io.*;

public class CreateFile {
    static public StringBuilder textAll= new StringBuilder("");
    public static void createFile() throws Exception {
        FileWriter fileWriter=new FileWriter("history.txt");

        fileWriter.append(textAll);
        fileWriter.close();

    }
    static public String getString() throws Exception {

        FileReader fileReader = new FileReader("history.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String res = "";
        String result = "";
        while ((res = bufferedReader.readLine())!=null){
            System.out.println(res);
            result += res+", ";
        }
        return  result;
    }
}
