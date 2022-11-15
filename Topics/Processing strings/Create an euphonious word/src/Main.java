import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        int countConsonants = 0;
        int countVowels = 0;
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' ||
                    text.charAt(i) == 'e' ||
                    text.charAt(i) == 'i' ||
                    text.charAt(i) == 'o' ||
                    text.charAt(i) == 'u' ||
                    text.charAt(i) == 'y') {
                countConsonants = 0;
                countVowels++;
                if (countVowels == 3) {
                    result++;
                    countVowels = 0;
                    i--;
                }
            } else {
                countVowels = 0;
                countConsonants++;
                if (countConsonants == 3) {
                    result++;
                    countConsonants = 0;
                    i--;
                }
            }
        }
        System.out.println(result);
    }
}