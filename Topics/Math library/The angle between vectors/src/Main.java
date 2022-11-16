import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double[] vector1 = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] vector2 = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double partOfResult = vector1[0] * vector2[0] + vector1[1] * vector2[1];
        double widthVentor1 = Math.sqrt(Math.pow(vector1[0], 2) + Math.pow(vector1[1], 2));
        double widthVentor2 = Math.sqrt(Math.pow(vector2[0], 2) + Math.pow(vector2[1], 2));
        double result = Math.acos(partOfResult / (widthVentor1 * widthVentor2));
        result = Math.toDegrees(result);
        System.out.println((int) result);

    }
}
