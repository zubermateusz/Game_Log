import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String textOutput = "";

        for (int i = 0; i < text.length(); i++) {
            textOutput += text.charAt(i);
            textOutput += text.charAt(i);
        }

        System.out.println(textOutput);
    }
}