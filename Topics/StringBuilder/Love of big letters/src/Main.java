import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        // write your code here
        StringBuilder finalMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (i % 2 == 0) { // big letter
                finalMessage.append(message.toUpperCase().charAt(i));
            } else { // small letter
                finalMessage.append(message.toLowerCase().charAt(i));
            }
        }
        return finalMessage.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}