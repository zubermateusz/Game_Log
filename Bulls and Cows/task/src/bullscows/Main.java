package bullscows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int bull = 0;
    static int cows = 0;

    public static void main(String[] args) {

        int[] secretCode = {2, 4, 7, 3}; // = new int[4]; // inicjalizacja miejsca na secretCode

        //secretCode = getCodeFromPlayer(); // pobranie SecretCode od gracza i wpisanie do tablicy

        int[] guessCode = getCodeFromPlayer(); // pobranie quessCode od gracza i wpisanie do tablicy
        checkCodes(secretCode, guessCode);

        endGame(secretCode, bull, cows);


/*        System.out.println("The secret code is prepared: ****.");

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
*/
    }

    private static void checkCodes(int[] secretCode, int[] guessCode) {
        bull = 0;
        cows = 0;
        for (int i = 0; i < secretCode.length; i++) { // bull++ gdy pozycja i cyfra jest taka sama
            if (secretCode[i] == guessCode[i]) {
                bull++;
            }
        }
        for (int i = 0; i < guessCode.length; i++) { // cows++ gdy taka sama cyfra jest w kodzie
            for (int j = 0; j < secretCode.length; j++) {
                if (i != j) {
                    if (guessCode[i] == secretCode[j]) {
                        cows++;
                    }
                }
            }
        }
    }

    private static int[] getCodeFromPlayer() { // pobranie kodu do porównania od gracza
        Scanner scanner = new Scanner(System.in);
        int[] code = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        return code;
    }

    private static void win(int[] secretCode) {
        System.out.printf("The secret code is %d.", secretCode);
    }

    private static void endGame(int[] code, int bull, int cows) {
        System.out.println("Grade: ");
        if (bull > 0) System.out.print(bull + " buss(s)");
        if (cows > 0) System.out.print(" and " + cows + " cows(s). ");
        System.out.println("The secret code is ".concat(printCode(code)));
    }

    private static String printCode(int[] code) { //wyswietlenie tablicy 1234
        String text = "";
        for (int number : code) {
            text += number;
        }
        return text;
    }
}
