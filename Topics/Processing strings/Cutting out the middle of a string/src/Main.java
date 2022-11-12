import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        if (text.length() % 2 == 0) {
            System.out.println(text.substring(0, text.length() / 2 - 1) + text.substring(text.length() / 2 + 1, text.length()));
        } else {
            System.out.println(text.substring(0, text.length() / 2) + text.substring(text.length() / 2 + 1, text.length()));
        }
    }
}