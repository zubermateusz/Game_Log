import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        // put your code here
        double x = scanner.nextDouble();
        double result = x * x * x;
        result += x * x;
        result += x + 1;
        System.out.println(result);
    }
}