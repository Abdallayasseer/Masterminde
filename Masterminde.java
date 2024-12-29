/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.masterminde;

import java.util.*;

/**
 *
 * @author Abdallah
 */
public class Masterminde {

    public static void main(String[] args) {
        final int MIN_CODE = 1000;
        final int MAX_CODE = 10000;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretCode = random.nextInt(MIN_CODE, MAX_CODE); // A 4 - number code
        System.out.println("Welcome to Mastermind! Try to guess 4 number.");

        int attempts = 0;
        boolean solved = false;

        while (attempts < 10 && !solved) {
            attempts++;
            System.out.print("Attempts : " + attempts + ": Enter your guess: ");
            try {
                int guess = scanner.nextInt();
                if (guess < MIN_CODE || guess >= MAX_CODE) {
                    System.out.println("Please enter a 4-digit number.");
                    attempts--;
                } else if (guess == secretCode) {
                    solved = true;
                    System.out.println("Congratulations! You guessed the secret code in " + attempts + " attempts!");
                } else {
                    // Count the digits 
                    int count = countCorrectDigits(secretCode, guess);
                    System.out.println("Number of correct digits: " + count);
                }
            } catch (Exception e) {
                attempts--;
                System.out.println("Invalid input, Please enter 4 number.");
                System.out.println("---------------------------------------");
                scanner.nextLine();
            }
        }

        if (!solved) {
            System.out.println("Better luck next time! The secret code was " + secretCode);
        }

    }

    private static int countCorrectDigits(int secretCode, int guess) {
        int count = 0;
        String secret = String.valueOf(secretCode);
        String guessStr = String.valueOf(guess);

        for (int i = 0; i < 4; i++) {
            if (secret.charAt(i) == guessStr.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
//by eng/Abdullah Yasser