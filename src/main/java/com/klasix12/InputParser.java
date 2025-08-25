package com.klasix12;

import java.util.Scanner;

public class InputParser {

    public int getUserInt(int maxNumber) {
        System.out.println(maxNumber + 1 + " - Close program");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                int inputNum = Integer.parseInt(input);
                if (inputNum == maxNumber + 1) {
                    System.exit(0);
                }
                if (inputNum < 1 || inputNum > maxNumber) {
                    System.out.println("Please enter a number between 1 and " + maxNumber);
                } else {
                    closeScanner(scanner);
                    return inputNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private void closeScanner(Scanner s) {
        s.close();
    }
}
