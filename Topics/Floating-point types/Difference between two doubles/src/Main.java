import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        // put your code here
        double x1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        System.out.println(x2 - x1);
    }
}