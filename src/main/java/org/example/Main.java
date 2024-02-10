package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static final double compareNum = 7;
    static final int division  = 3;
    static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    static final String compareName = "Вячеслав";

    public static void main(String[] args) {
        System.out.print("""
                Поддерживает числовые и строчные входные данные\s
                Для ввода числового массива пишите как обычный массив с []
                """);
        Scanner input = new Scanner(System.in);
        System.out.print("Введите значение: ");
        String text = input.nextLine();


        if (pattern.matcher(text).matches()) {
            double number = Double.parseDouble(text);
            if (number > compareNum){
                System.out.println("Привет");
            }
        }
        else {
            if (text.charAt(0) == '[' &&  text.charAt(text.length() - 1) == ']') {
                String[] values_array = text.substring(1, text.length() - 1).split(",");
                StringBuilder cur_numbers = new StringBuilder();
                for (String st: values_array){
                    try {
                        if (Integer.parseInt(st) % division == 0) {
                            cur_numbers.append(st).append(", ");
                        }
                    }
                    catch (java.lang.NumberFormatException e){
                        System.out.println("Не правильно представлен массив. Пример: [1,3,4,5]");
                        return;
                    }
                }
                int len = cur_numbers.length();
                System.out.println("элементы массива кратные "+division+": " + cur_numbers.delete(len-2, len-1));
            } else if (text.equals(compareName)) {
                System.out.println("Привет, " + compareName);
            }
            else {
                System.out.println("Нет такого имени");
            }
        }
    }
}