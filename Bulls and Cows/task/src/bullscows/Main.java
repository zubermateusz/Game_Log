package bullscows;



import java.util.*;


public class Main {

    static int bull = 0;
    static int cows = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        try {
            int numberOfCodeDigits = scanner.nextInt();// pobranie od gracza dlugosci kodu
            if (numberOfCodeDigits < 1) {
                System.out.println("Error: ");
                System.exit(0);
            }
            System.out.println("Input the number of possible symbols in the code:");
            int numberOfLetters = scanner.nextInt();

            if (numberOfLetters < 37) { //przerwanie jesli gracz bedzie chcial zbudowac kod z wiecej niz 36 unikalnych znakow
                if (numberOfLetters >= numberOfCodeDigits) { //przerwanie jesli gracz poda zbyt malo ukinalnych znakow do budowy kodu
                    System.out.println("Okay, let's start a game!");

                    StringBuilder secretCode = generateCode(numberOfCodeDigits, numberOfLetters);// inicjalizacja miejsca na secretCode
                    StringBuilder playerCode;

                    int turn = 0;
                    do {
                        System.out.println("Turn " + ++turn + ":");
                        playerCode = getCodeFromPlayer();
                        if (playerCode.length() != numberOfCodeDigits) { //przerwanie jesli gracz poda za krotki lub za dlugi kod
                            System.out.printf("Error: the code has got d% digits", numberOfCodeDigits);
                            break;
                        }
                        checkCodes(secretCode, playerCode);
                        endGame(secretCode, bull, cows);
                    } while (bull != numberOfCodeDigits);
                } else {
                    System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", numberOfCodeDigits, numberOfLetters);
                }
            } else {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            }
        }catch (InputMismatchException e) {
            System.out.println("Error: isn't a valid number.");
        }
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
            StringBuilder digitBaseForGenerate = new StringBuilder(digitBase.append(lettersBase).substring(0, numberOfLetters));
            String text = "The secret is prepared: ";
            for (int i = 0; i < codeLength; i++) {
                text += "*";
            }
            text += " (0-9, a-" + digitBase.charAt(numberOfLetters - 1) + ").";
            System.out.println(text);


            for (int i = 0; i < codeLength; i++) {
                int temp = new Random().nextInt(digitBaseForGenerate.length() - 1);
                code.append(digitBaseForGenerate.charAt(temp));
                digitBaseForGenerate.deleteCharAt(temp);
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

           }
        }

    } //wyswietlenie Grade:/None.  bull(s) and cow(s). The secret code is code

    private static String printCode(StringBuilder code) {
        return code.toString();
    }//wyswietlenie tablicy 1234
}
