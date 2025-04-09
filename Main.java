package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean runAgain = true;

        System.out.println("Welcome to the Square Number Checker Program!");

        while (runAgain) {
            int number = getValidNumber(scanner);
            checkSquareNumber(number);

            runAgain = askToRunAgain(scanner);
        }

        System.out.println("Thank you for using the program! Goodbye!");
        scanner.close();
    }

    private static int getValidNumber(Scanner scanner) {

        int attempts = 0;
        int number = 0;
        boolean validInput = false;

        while (!validInput && attempts < 5) {
            System.out.print("Please enter a positive integer less than or equal to 10_000: ");

            //Using scanner.hasNext() instead of try-catch
            if (scanner.hasNext()) {
                number = scanner.nextInt();
                scanner.nextLine(); //Consume newline
            }

            if (number > 0 && number <= 10_000) {
                validInput = true;
            } else {
                attempts++;
                if (attempts <= 2) {
                    System.out.println("Invalid input! The number must be positive and ≤ 10_000.");
                } else if (attempts <= 4) {
                    System.out.println("Still invalid input! Example valid input: 25 (positive, intenger, ≤ 10_000)");
                }
            }

            if (attempts >= 5) {
                System.out.println("Too many incorrect attempts. The program will now exit.");
                System.exit(0);
            }
        }

        return number;
    }

    private static void checkSquareNumber(int number) {

        int sqrt = (int) Math.sqrt(number);

        //Easter egg for 42 squared (1764)
        if (number == 1764) {
            System.out.println("BINGO!");
        }

        if (sqrt * sqrt == number) {
            System.out.println(number + " is a perfect square, as " + sqrt + " x " + sqrt + " = " + number);
        } else {
            int lowerSquare = sqrt * sqrt;
            int higherSquare = (sqrt + 1) * (sqrt + 1);

            System.out.println(number + " is not a perfect square.");
            System.out.println("The nearest lower perfect square: " + lowerSquare + "(" + sqrt + " x " + sqrt + " = " +
                    " = " + lowerSquare + ")");
            System.out.println("The nearest higher perfect square: " + higherSquare + "(" + (sqrt + 1) + " x " + (sqrt +
                    1) + " = " + higherSquare + ")");
        }
    }

    private static boolean askToRunAgain(Scanner scanner) {

        System.out.print("Would you like to run the program again? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        return response.equals("yes") || response.equals("y");
    }
}

/**
 * Write a Java program that meets the following requirements:
 * ➢ Upon startup, the program prints a user-friendly message to the standard output and prompts the user to enter a
 * positive integer smaller than 10,000 (10,000 itself is considered valid input).
 * ➢ It reads the number from the user.
 * ➢ Validates the number, and if it does not meet the conditions (not positive, not ≤ 10,000), it notifies the user
 * with a message and prompts them to enter the number again.
 * ➢ If the user provides incorrect input more than twice, the program displays another message on the standard
 * output, including a hint (what conditions the number must satisfy, along with an example).
 * ➢ If the user provides incorrect input more than five times, the program prints a message to the standard output
 * stating that it cannot continue with this input and terminates.
 * ➢ If the user successfully enters a valid number, the program checks whether the number is a perfect square
 * (e.g., 1×1=1, 2×2=4, 3×3=9, 4×4=16, etc.).
 * ➢ If it is a perfect square, the program prints to the standard output that it is a perfect square and specifies
 * which number's square it is.
 * ➢ If it is not a perfect square, the program prints that it is not a perfect square and determines the nearest
 * smaller and larger perfect squares, then prints them along with which numbers' squares they are.
 * ➢ After successful execution, the program asks the user whether they want to run it again and, depending on the
 * user's response, either restarts or terminates.
 * ➢ Build an Easter egg into the program: If the user enters the square of 42 (i.e., 1764), the program should
 * additionally print: "BINGO!"
 */
