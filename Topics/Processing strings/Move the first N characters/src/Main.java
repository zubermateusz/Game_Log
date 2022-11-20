import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int digit = scanner.nextInt();
        if (digit > text.length()) {
            digit = text.length();
        }
        System.out.println(text.substring(digit) + text.substring(0, digit));
    }
}