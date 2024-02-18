package java8;

import java.util.Scanner;

public class Tokenizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        tokenizeString(input);
    }

    public static void tokenizeString(String input) {
        // Splitting the input string into tokens based on non-alphabetic characters
        String[] tokens = input.split("[^A-Za-z]+");

        // Counting tokens and printing them
        int count = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) { // Ignore empty strings
                count++;
                System.out.println(token);
            }
        }

        // Printing the total number of tokens
        System.out.println(count);
    }
}
