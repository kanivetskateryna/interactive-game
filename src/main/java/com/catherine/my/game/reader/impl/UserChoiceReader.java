package com.catherine.my.game.reader.impl;

import com.catherine.my.game.reader.Reader;
import com.catherine.my.game.util.ConsoleColors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A {@code Reader} implementation that reads an integer choice from the user via the standard input.
 * This class prompts the user to make a choice within a specified range and validates the input.
 */
public class UserChoiceReader implements Reader<Integer> {

    private final BufferedReader reader;

    /**
     * Constructs a new {@code UserChoiceReader} with a {@link BufferedReader}
     * to read text from the standard input stream.
     */
    public UserChoiceReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Prompts the user for a choice and validates that it is within the specified range.
     * The method will continuously prompt the user until a valid integer is entered.
     *
     * @param input the upper limit of the user's choice (assumes a lower limit of 1)
     * @return the user's choice as an integer within the range [1, input]
     * @throws NumberFormatException if the user enters an invalid number
     */
    @Override
    public Integer read(Integer input) {
        int choice = 0;
        boolean isValidChoice = false;

        do {
            try {
                System.out.print(ConsoleColors.RESET + "Ваш вибір (1 до " + input + "): ");
                choice = Integer.parseInt(reader.readLine());
                isValidChoice = (choice >= 1 && choice <= input);
            } catch (IOException e) {
                System.err.println("Error reading from input. Please try again.");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Некоректне число. Будь ласка, оберіть число від 1 до " + input + ".");
            }
        } while (!isValidChoice);

        return choice;
    }
}

