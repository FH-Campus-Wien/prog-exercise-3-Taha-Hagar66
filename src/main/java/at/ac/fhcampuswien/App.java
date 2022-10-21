package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {


    public static void oneMonthCalendar(int numberDay, int startingDay) {
        int row = 0;
        int col = -1;

        for (int i = 0; i < numberDay; i++) {
            for (int j = 1; j < startingDay && i == 0; j++) {
                System.out.print("   ");
                col++;
            }
            col++;
            row++;
            if (col % 7 == 0) {
                System.out.println();
            }
            System.out.printf("%2d ", row);
        }
        System.out.println();
    }


    public static long[] lcg(long seed) {

        long[] arr = new long[10];
        long a = 1103525345;
        long c = 12345;
        double m = Math.pow(2, 31);
        long m_long = (new Double(m)).longValue();

        for (int i = 1; i < 10; i++) {
            arr[i] = (a * arr[i - 1] + c) % m_long;
        }
        return arr;
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(100) + 1;

    }


    public static void guessingGame(int numberToGuess) {
        for (int i = 1; i <= 10; i++) {
            Scanner sc = new Scanner(System.in);
            int guess = 0;

            System.out.print("Guess number " + i + ": ");
            guess = sc.nextInt();
            if (i == 10 && numberToGuess != guess) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            if (numberToGuess < guess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (numberToGuess > guess) {
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (guess == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
        }
    }



    public static boolean swapArrays(int [] arr1, int [] arr2){
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++){
            int temporary = arr1[i];
            arr1[i] = arr2 [i];
            arr2[i] = temporary;
        }

        return true;

    }


    public static String camelCase(String conToCamel){
        conToCamel = conToCamel.substring(0, 1).toUpperCase() + conToCamel.substring(1).toLowerCase();
        StringBuilder builder = new StringBuilder(conToCamel);

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '!'|| builder.charAt(i) == '.'){
                builder.deleteCharAt(i);
            } else if (builder.charAt(i) == '\'') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(builder.charAt(i)));
            } else if (builder.charAt(i) == ' ') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));

            }
        }

        return builder.toString();
    }


    public static int checkDigit (int []array){
        int sum = 0;

        for (int i = 0; i < array.length; i++){
            sum += array[i] * (i + 2);
        }
        int preufziffer = 11 - sum % 11;

        if (preufziffer == 10) {
            preufziffer = 0;
        }
        else if (preufziffer == 11) {
            preufziffer = 5;
        }
        return preufziffer;
    }


    public static void main(String[] args) {

        System.out.println("Task 1: One Month Calendar");
        oneMonthCalendar(28, 1);

        System.out.println("\nTask 2: Pseudo Random Numbers");
        for (long n:lcg(5)){
            System.out.println(n);
        }

        System.out.println("\nTask 3: Guessing Game");
        System.out.println();
        guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println("\nTask 4: Swap Arrays");
        int [] arr1 = {1,2,3,4};
        int [] arr2 = {4,3,2,1};
        System.out.println();
        System.out.println("Before Swap:");
        System.out.println("Array1 => "+ java.util.Arrays.toString(arr1));
        System.out.println("Array2 => "+ java.util.Arrays.toString(arr2));
        System.out.println();

        swapArrays(arr1, arr2);
        System.out.println("After Swap:");
        System.out.println("Array1 => "+ java.util.Arrays.toString(arr1));
        System.out.println("Array2 => "+ java.util.Arrays.toString(arr2));

        System.out.println("\nTask 5: CamelCase");
        System.out.println();
        System.out.print("Convert into camelcase: ");
        Scanner scr = new Scanner(System.in);
        String convertToCamelCase = scr.nextLine();
        camelCase(convertToCamelCase);
        System.out.println(camelCase(convertToCamelCase));
        System.out.println();

        System.out.println("\nTask 6: Check Digit");
        System.out.println(checkDigit(new int [] {3,9,1,5,8}));

    }


}