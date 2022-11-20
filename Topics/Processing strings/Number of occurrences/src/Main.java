
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        String textInside = scanner.nextLine();
        int count = 0;
        int textIndex = text.indexOf(textInside);
        while (textIndex != -1) {
            count++;
            text.delete(textIndex, textIndex + textInside.length());
            textIndex = text.indexOf(textInside);
        }
        System.out.println(count);
    }
}