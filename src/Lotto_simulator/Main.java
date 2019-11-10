package Lotto_simulator;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] userNumbers = getUserNumbers();

        Arrays.sort(userNumbers);

        System.out.println("User numbers: " + Arrays.toString(userNumbers));


        Integer[] randomNumbers = uniqueGenerator();

        System.out.println("Random numbers: "+Arrays.toString(randomNumbers));

    }

    private static int[] getUserNumbers() {
        Scanner scanner = new Scanner(System.in);

        int[] userNumber = new int[6];

        for (int i = 0; i < 6; i++) {
            int index = i + 1;
            System.out.print("Podaj liczbę " + index + " : ");
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Nie liczba.\nPodaj liczbę " + index + " : ");
                    scanner.next();
                }
                int number = scanner.nextInt();
                if (isNumberOK(userNumber, number, index)) {
                    userNumber[i] = number;
                    break;
                }
            }
        }
        return userNumber;
    }

    private static boolean isNumberOK(int[] userNumbers, int number, int index) {
        if (number < 1 || number > 49) {
            System.out.print("Od 1 do 49.\nPodaj liczbę " + index + " : ");
            return false;
        }
        for (int i = 0; i < userNumbers.length; i++) {
            if (userNumbers[i] == number) {
                System.out.print("Podałeś już tę liczbę.\nPodaj liczbę " + index + " : ");
                return false;
            }
        }
        return true;
    }

    static Integer[] uniqueGenerator() {

        Integer[] arr = new Integer[49];

        for (int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }

        Collections.shuffle(Arrays.asList(arr));

        arr = Arrays.copyOfRange(arr, 0, 6);

        Arrays.sort(arr);

        return arr;
    }
}
