import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char sign = text.charAt(0); // pobranie pierwszego znaku z tekstu do porownania
        int count = 1;
        String compressionText = ""; // text wynikowy
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == sign) { // porownanie znaku z tekstu z poprzednim znakiem
                count++;
            } else {
                compressionText = compressionText + sign  + count;
                sign = text.charAt(i); // pobranie kolejnego innego znaku
                count = 1;
            }
        }
        compressionText = compressionText + sign  + count; // ostatnie znaki
        System.out.println(compressionText);
    }
}