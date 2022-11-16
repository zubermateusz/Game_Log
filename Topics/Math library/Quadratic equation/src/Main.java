import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        float a;
        float b;
        float c;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        a = scanner.nextFloat();
        b = scanner.nextFloat();
        c = scanner.nextFloat();

        float delta;
        delta = b * b - 4 * a * c;
        double x1;
        double x2;
        x1 = (-b + Math.sqrt(delta)) / (2 * a);
        x2 = (-b - Math.sqrt(delta)) / (2 * a);
        if (x1 > x2) {
            System.out.println(x2 + " " + x1);
        } else {
            System.out.println(x1 + " " + x2);
        }
    }
}
