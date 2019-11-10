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