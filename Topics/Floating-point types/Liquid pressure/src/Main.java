import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double p = scanner.nextDouble();
        double h = scanner.nextDouble();
        double result = p * 9.8 * h;
        System.out.println(result);
    }
}