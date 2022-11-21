package bullscows;



import java.util.*;


public class Main {

    static int bull = 0;
    static int cows = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        int numberOfCodeDigits = scanner.nextInt();// pobranie od gracza dlugosci kodu

        System.out.println("Input the number of possible symbols in the code:");
        int numberOfLetters = scanner.nextInt();

        System.out.println("Okay, let's start a game!");

        StringBuilder secretCode = generateCode(numberOfCodeDigits, numberOfLetters);//{2, 4, 7, 3}; // = new int[4]; // inicjalizacja miejsca na secretCode
        StringBuilder playerCode;

        int turn = 0;
        do {
            System.out.println("Turn " + ++turn + ":");
            playerCode = getCodeFromPlayer();
            checkCodes(secretCode, playerCode);
            endGame(secretCode, bull, cows);
        } while (bull != numberOfCodeDigits);

        //secretCode = getCodeFromPlayer(); // pobranie SecretCode od gracza i wpisanie do tablicy

        //int[] guessCode = getCodeFromPlayer(); // pobranie quessCode od gracza i wpisanie do tablicy
        //checkCodes(secretCode, guessCode); // porownanie kodow

        //endGame(secretCode, bull, cows); // wyswietlenie wyniku konczacego rozgrywke
        //win(secretCode);

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

    private static StringBuilder generateCode(int codeLength, int numberOfLetters) {
        StringBuilder code = new StringBuilder(codeLength);
        if (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a " +
                    "length of " + codeLength + " because there aren't enough unique digits.");
            System.exit(0);
        } else {
            StringBuilder digitBase = new StringBuilder("1234567890");
            StringBuilder lettersBase = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
            digitBase.append(lettersBase);
            String text = "The secret is prepared: ";
            for (int i = 0; i < codeLength; i++) {
                text += "*";
            }
            text += " (0-9, a-" + digitBase.charAt(numberOfLetters - 1) + ").";
            System.out.println(text);


            for (int i = 0; i < codeLength; i++) {
                int temp = new Random().nextInt(numberOfLetters - 1);
                code.append(digitBase.charAt(temp));
                digitBase.deleteCharAt(temp);
            }
        }
        return code;
    }

    private static void checkCodes(StringBuilder secretCode, StringBuilder guessCode) {
        bull = 0;
        cows = 0;
        for (int i = 0; i < secretCode.length(); i++) { // bull++ gdy pozycja i cyfra jest taka sama
            if (secretCode.charAt(i) == guessCode.charAt(i)) {
                bull++;
                guessCode.deleteCharAt(i);
                guessCode.insert(i,' ');
            }
        }
        for (int i = 0; i < guessCode.length(); i++) {// cows++ gdy taka sama cyfra jest w kodzie
            if (bull == secretCode.length()) {
                break;
            }
            for (int j = 0; j < secretCode.length(); j++) {
                if (guessCode.charAt(i) == secretCode.charAt(j)) {
                    cows++;
                    guessCode.deleteCharAt(i);
                    guessCode.insert(i,' ');
                }
            }
        }
    }//porowanie kodow i przypisanie bulls i cows

    private static StringBuilder getCodeFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder code = new StringBuilder(scanner.nextLine());
        return code;
    }// pobranie kodu do porównania od gracza

    private static void win(StringBuilder code) {
        System.out.printf("The random secret code is %s.", printCode(code));
    } // wyswietlenie The secret code is secretCode

    private static void endGame(StringBuilder code, int bull, int cows) {
        if (bull == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else {
            if (bull == code.length()) {
                System.out.println("Grade: " + bull + " bulls");
                System.out.println("Congratulations! You guessed the secret code.");
            } else {
                System.out.println("Grade: " + bull + " bulls" + " and " + cows + " cows");
/*                System.out.print("Grade: ");
                if (bull == 1) System.out.print(bull + " bull");
                if (cows == 1) System.out.print(" and " + cows + " cow");

                if (bull > 1) System.out.print(bull + " bulls");
                if (cows > 1) System.out.print(" and " + cows + " cows ");
*/
           }
        }
        // System.out.print("The secret code is ".concat(printCode(code)));
        //System.out.println();
    } //wyswietlenie Grade:/None.  bull(s) and cow(s). The secret code is code

    private static String printCode(StringBuilder code) {
        return code.toString();
    }//wyswietlenie tablicy 1234
}
