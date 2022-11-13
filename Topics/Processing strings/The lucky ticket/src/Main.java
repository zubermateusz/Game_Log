import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int temp1Half = 0;
        int temp2Half = 0;
        for (int i = 0; i < text.length() / 2; i++) {
            temp1Half += Integer.parseInt(text.charAt(i) + "");
        }

        for (int i = text.length() / 2; i < text.length(); i++) {
            temp2Half += Integer.parseInt(text.charAt(i) + "");
        }

        if (temp2Half != temp1Half) {
            System.out.println("Regular");
        } else {
            System.out.println("Lucky");
        }
    }
}