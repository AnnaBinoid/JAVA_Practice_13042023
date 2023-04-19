package Lesson2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    //.toString();
    // Дано четное число N (>0) и символы c1 и c2.
    // Написать метод, который вернет строку длины N, которая состоит из чередующихся
    // символов c1 и c2, начиная с c1.

    public static void main(String[] args) {

//        stringWithTwoSymbols(5);
//        System.out.println(stringWithTwoSymbols(6));
//        System.out.println(zipString(zipString("aaabbbbbbcddefff")));
//        System.out.println(isStrPalindrom("а роза упала на лапу азора"));
//        String test = repeat100TimesTest();
//        String fName = "test.txt";
//        saveStrToFile(fName,test);
        ex5("C:\\Users\\User\\IdeaProjects\\JAVA_Practice_13042023");



    }

    private static void stringWithTwoSymbols(int n) {

        StringBuilder result = new StringBuilder();
        char charOne = 'A';
        char charTwo = 'B';

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result.append(charTwo);
            } else {
                result.append(charOne);
            }
        }
        System.out.println(result);
    }



    /*    Напишите метод, который сжимает строку.
        Пример: вход aaaabbbcdd.*/

    private static String zipString(String inputStr) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < inputStr.length(); i++) {
            if (inputStr.charAt(i - 1) == inputStr.charAt(i)) {  // получаем текущий символ
                count++;
                if (i == inputStr.length() - 1) {
                    result.append(inputStr.charAt(i));
                    if (count >= 1) {
                        result.append(count);
                    }
                }
            } else {
                result.append(inputStr.charAt(i - 1));
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
                if (i == inputStr.length() - 1) {
                    result.append(inputStr.charAt(i));
                }
            }

        }
        return result.toString();

    }

 /*   public static String zipString(String inputStr) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < inputStr.length(); i++) {

            char currentChar = inputStr.charAt(i - 1);
            if (inputStr.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(currentChar);
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            }
            if (i == inputStr.length() - 1) {
                result.append(inputStr.charAt(i));
                if (count > 1) {
                    result.append(count);
                }
            }
        }
        return result.toString();
    }*/


/*    Напишите метод, который принимает на вход строку (String) и определяет
    является ли строка палиндромом (возвращает boolean значение).*/

    private static boolean isStrPalindrom(String inputStr) {
        inputStr = inputStr.toLowerCase().replace(" ", "").replace("-", "");
        for (int i = 0; i < inputStr.length() / 2; i++) {
            if (inputStr.charAt(i) != (inputStr.charAt(inputStr.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }



/* Напишите метод, который составит строку, состоящую из 100 повторений слова
TEST и метод, который запишет эту строку в простой текстовый файл, обработайте
 исключения.*/
    private static String repeat100TimesTest() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100; i++){
            result.append("TEST\n");
        }
        return result.toString();
    }

    public static void saveStrToFile(String fileName, String inputString){
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(inputString);
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    private static void ex5(String pathDir) {
        File file = new File(pathDir);
        if (!(file.exists() || file.isDirectory())){   // если файл не существует или файл не директория
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (String fileName : file.list()){
            sb.append(fileName).append(System.lineSeparator()); // универсальный перенос строки

        }
        System.out.println(sb);

 //       PrintWriter pw = new PrintWriter("");
 //       pw.print(sb);
    }


}




