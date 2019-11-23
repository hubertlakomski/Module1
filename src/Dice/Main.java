package Dice;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String code = getString();

        throwQube(code);
    }

    static void throwQube(String code) {
        int count = getNumberOfThrows(code);
        int modifier = getModifier(code);
        int qubeType = getType(code);

        int sum = modifier;

        for (int i = 0; i < count; i++) {

            sum += generator(1, qubeType);

        }

        System.out.println("Wynik: " + sum);

    }

    static int generator(int from, int to) {

        Random r = new Random();

        return r.nextInt(to - from + 1) + from;
    }

    static String getString() {

        /*
            input: xDy+z

            y -> the type of cubes to use
            x -> number of dice rolls (if we roll once, this parameter is skipped)
            z- > (optional) a number to add (or subtract) to the result of the throws

            example input:

            2D10+10 -> 2 throws using 10 wall cube and add 10 to the result
            D6 -> simple throw using 6 wall cube
            2D3 -> 2 throws using 3 wall cube
            D12-1 -> simple throw using 12 wall cube and subtract 1 of the result

         */

        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj kod: ");

        return scan.next();
    }

    static int getNumberOfThrows(String code) {

        String[] numberOfThrows = code.split("D");

        int count = 1;

        try {
            if (Integer.parseInt(numberOfThrows[0]) > 1) {
                count = Integer.parseInt(numberOfThrows[0]);
            }

            return count;
        } catch (NumberFormatException ex) {

            return count;
        }
    }

    static int getModifier(String code) {

        if (code.contains("+")) {
            String[] plusModifier = code.split("\\+");
            return Integer.parseInt(plusModifier[1]);
        } else if (code.contains("-")) {
            String[] minusModifier = code.split("-");
            return (Integer.parseInt(minusModifier[1])) * (-1);
        } else {
            return 0;
        }
    }

    static int getType(String code) {

        if (code.contains("+")) {
            String[] type = code.split("\\+");
            String[] tmp = type[0].split("D");
            return Integer.parseInt(tmp[1]);
        }
        else if (code.contains("-")) {
            String[] type = code.split("-");
            String[] tmp = type[0].split("D");
            return Integer.parseInt(tmp[1]);
        }
        else {
            String[] tmp = code.split("D");
            return Integer.parseInt(tmp[1]);
        }

    }
}