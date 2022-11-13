import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        int position = text.indexOf("the");
        System.out.println(position);
    }
}