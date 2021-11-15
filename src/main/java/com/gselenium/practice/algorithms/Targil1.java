package com.gselenium.practice.algorithms;

public class Targil1 {
    public static void main(String[] args) {
        char[] numbers = "1234".toCharArray();
        int number = Character.getNumericValue(numbers[2]);
        System.out.println(number); // Prints 1

        int n = 345;
        int calculated = n / 100;
        System.out.println(calculated);

        char[] digital = "49".toCharArray();
        int dig1 = Character.getNumericValue(digital[0]);
        int dig2 = Character.getNumericValue(digital[1]);
        int sum = dig1 + dig2;
        System.out.println("sum= " + sum); // Prints 13
        String str = Integer.toString(sum);
        StringBuilder str1 = new StringBuilder();
        // append a string into StringBuilder input1
        str1.append(str);
        // reverse StringBuilder input1
        str1.reverse();
        // print reversed String
        System.out.println(str1);

//13 exe: get int value and print the next even number
        int n1 = 4;
        n1++;
        if (n1 % 2 == 1) // make sure that num is even
            n1++;
        System.out.println(n1);
    }
}
