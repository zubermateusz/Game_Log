import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'G' || text.charAt(i) == 'g' || text.charAt(i) == 'C' || text.charAt(i) == 'c') {
                count++;
            }
        }
        System.out.println((double) count / text.length() * 100);
    }
}