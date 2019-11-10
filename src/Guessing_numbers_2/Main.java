package Guessing_numbers_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbaach");

        int min = -1;
        int max = 1001;
        int guess = -1;

        Scanner scan = new Scanner(System.in);

        while(true){
            guess = ((max-min)/2) + min;
            System.out.println("Zgaduję "+guess);
            System.out.println("Podpowiedz: ");
            String userAnswer = scan.nextLine();

            if("zgadłeś".equals(userAnswer)){
                System.out.println("Wygrałem");
                break;
            }
            else if("za dużo".equals(userAnswer)){
                max = guess;
            }
            else if("za mało".equals(userAnswer)){
                min = guess;
            }
            else {
                System.out.println("nie oszukuj");
            }

        }

    }
}
