package bullscows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int bull = 0;
    static int cows = 0;

    public static void main(String[] args) {

        int[] secretCode = {2, 4, 7, 3}; // = new int[4]; // inicjalizacja miejsca na secretCode

        //secretCode = getCodeFromPlayer(); // pobranie SecretCode od gracza i wpisanie do tablicy

        int[] quessCode = getCodeFromPlayer(); // pobranie quessCode od gracza i wpisanie do tablicy


        endGame(secretCode, bull, cows);


        System.out.println("The secret code is prepared: ****.");

        System.out.println("Turn 1. Answer:\n" +
                "1234\n" +
                "Grade: 1 cow.");

        System.out.println("Turn 3. Answer:\n" +
                "9012\n" +
                "Grade: 1 bull and 1 cow.");

        System.out.println("Turn 7. Answer:\n" +
                "9305\n" +
                "Grade: 4 bulls.");
        System.out.println("Turn 7. Answer:\n" +
                "9305\n" +
                "Grade: 4 bulls.");
        //win(secretCode); // wyswietla tekst wygranej
        System.out.println("Congrats! The secret code is 9305.");
    }

    private static int[] getCodeFromPlayer() { // pobranie kody do porównania od gracza
        Scanner scanner = new Scanner(System.in);
        int[] guessCode = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        return guessCode;
    }

    private static void win(int[] secretCode) {
        System.out.printf("The secret code is %d.", secretCode);
    }

    private static void endGame(int[] secretCode, int bull, int cows) {
        System.out.println("Grade: ");
        if (bull > 0) System.out.print(bull + " buss(s)");
        if (cows > 0) System.out.print(" and " + cows + " cows(s). ");
        System.out.println("The secret code is ".concat(printCode(secretCode)));
    }

    private static String printCode(int[] secretCode) { //wyswietlenie tablicy 1234
        String text = "";
        for (int number : secretCode) {
            text += number;
        }
        return text;
    }
}
