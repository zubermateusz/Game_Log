package bullscows;



import java.util.*;


public class Main {

    static int bull = 0;
    static int cows = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int numberOfCodeDigits = scanner.nextInt(); // pobranie od gracza dlugosci kodu

        int[] secretCode = generateCode(numberOfCodeDigits);//{2, 4, 7, 3}; // = new int[4]; // inicjalizacja miejsca na secretCode
        //System.out.println(printCode(secretCode));
        int[] playerCode = new int[numberOfCodeDigits];
        System.out.println("Okay, let's start a game!");
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

    private static int[] generateCode(int codeLength) {
        int[] code = new int[codeLength];
        if (codeLength > 10) {
            System.out.println("Error: can't generate a secret number with a " +
                    "length of " + codeLength + " because there aren't enough unique digits.");
            System.exit(0);
        } else {
            StringBuilder digitBase = new StringBuilder("1234567890");
            for (int i = 0; i < codeLength; i++) {
                int temp = new Random().nextInt(digitBase.length());
                code[i] = Integer.parseInt(digitBase.charAt(temp) + "");
                digitBase.deleteCharAt(temp);
            }

        }
        return code;
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
    }//porowanie kodow i przypisanie bulls i cows

    private static int[] getCodeFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int[] code = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        return code;
    }// pobranie kodu do porównania od gracza

    private static void win(int[] code) {
        System.out.printf("The random secret code is %s.", printCode(code));
    } // wyswietlenie The secret code is secretCode

    private static void endGame(int[] code, int bull, int cows) {
        System.out.print("Grade: ");
        if (bull == 0 && cows == 0) {
            System.out.print("None. ");
        }
        if (bull == code.length) {
            System.out.println("Congratulations! You guessed the secret code.");
        } else {
            if (bull == 1) System.out.print(bull + " bull");
            if (cows == 1) System.out.print(" and " + cows + " cow");

            if (bull > 1) System.out.print(bull + " bull(s)");
            if (cows > 1) System.out.print(" and " + cows + " cow(s). ");
        }
        // System.out.print("The secret code is ".concat(printCode(code)));
        System.out.println();
    } //wyswietlenie Grade:/None.  bull(s) and cow(s). The secret code is code

    private static String printCode(int[] code) {
        String text = "";
        for (int digit : code) {
            text += digit;
        }
        return text;
    }//wyswietlenie tablicy 1234
}
