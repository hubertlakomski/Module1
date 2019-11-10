package Guessing_numbers;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int randNumber = generator(1, 100);

        try {
            getNumber(randNumber);
        }
        catch (Exception ex){
            System.out.println("To nie jest liczba");
            getNumber(randNumber);
        }
    }

    static void getNumber(int randNumber){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zgadnij liczbę: ");

        checkNumber(scanner.nextInt(), randNumber);
    }

    static void checkNumber(int number, int randNumber){

        if(number<randNumber){
            System.out.println("Za mało!");
            getNumber(randNumber);
        }
        else if(number>randNumber){
            System.out.println("Za dużo!");
            getNumber(randNumber);
        }
        else {
            System.out.println("Zgadłeś!");
        }

    }

    static int generator(int from, int to){

        Random r = new Random();

        return r.nextInt(to - from + 1) + from;
    }

}
