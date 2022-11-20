import java.util.*;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        // write your code here
        /*
        * A uppercase letters, at least B lowercase letters, at least C digits and consists of exactly N symbols
        * */

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];
        arr[0] = scanner.nextInt();
        arr[1] = scanner.nextInt();
        arr[2] = scanner.nextInt();
        arr[3] = scanner.nextInt();


        String code = "";

        //tablice znakow
        String a = "AB";
        String b = "ab";
        String c = "12";

        String tempCode = "";
        for (int i = 0; tempCode.length() < arr[0]; i++) {
            tempCode += a;
        }
        code += tempCode.substring(0, arr[0]);

        tempCode = "";
        for (int i = 0; tempCode.length() < arr[1]; i++) {
            tempCode += b;
        }
        code += tempCode.substring(0, arr[1]);

        tempCode = "";
        for (int i = 0; tempCode.length() < arr[2]; i++) {
            tempCode += c;
        }
        code += tempCode.substring(0, arr[2]);



        for (int i = 0; code.length() < arr[3]; i++) {
            if (code.length() == 0) {
                code += a;
            } else {
                if (code.charAt(code.length() - 1) == a.charAt(0)) {
                    code += a.charAt(1);
                }
                code += a;
            }
        }
        code = code.substring(0, arr[3]);



        System.out.println(code);
    }
}