import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        // put your code here
        System.out.println(scanner.nextDouble() * 10.5 + scanner.nextDouble() *
                4.4 + (scanner.nextDouble() + scanner.nextDouble()) / 2.2);
    }
}