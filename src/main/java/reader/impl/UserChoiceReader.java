package reader.impl;

import reader.Reader;
import util.ConsoleColors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserChoiceReader implements Reader<Integer> {

    private final BufferedReader reader;

    public UserChoiceReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

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
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Некоректне число. Будь ласка, оберіть число від 1 до " + input + ".");
            }
        } while (!isValidChoice);

        return choice;
    }
}
