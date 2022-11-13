import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        boolean flag = true;
        for (int i = 0, k = text.length() - 1; i < text.length(); i++, k--) {
            if (text.charAt(i) != text.charAt(k)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}