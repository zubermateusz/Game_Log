import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int length = 0;
        String napis = "";
        for (String text : arr) {
            if (text.length() > length) {
                length = text.length();
                napis = text;
            }
        }
        System.out.println(napis);
    }
}