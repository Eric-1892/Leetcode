package encryption_decryption;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther:
 * @Date: 2023/10/13/8:34 PM
 * @Description: This class provides a Rail Fence Cipher decryption algorithm.
 * It is designed to decrypt ciphertext using a provided key and restore the original plaintext.
 */
public class railFenceCipher {
    public String decryption(String s, int numRows) {
        if (numRows == 1) return s;
        char[] ans = new char[s.length()];
        int n = s.length();
        int diff = 2 * (numRows - 1);
        int diagonalDiff = diff;
        int secondIndex;
        int index;
        int cumulativeIndex = 0;
        for (int i = 0; i < numRows; i++) {
            index = i;
            while (index < n) {
                ans[index] = s.charAt(cumulativeIndex);
                cumulativeIndex++;
                if (i != 0 && i != numRows - 1) {
                    diagonalDiff = diff-2*i;
                    secondIndex = index + diagonalDiff;

                    if (secondIndex < n){
                        ans[secondIndex] = s.charAt(cumulativeIndex);
                        cumulativeIndex++;
                    }
                }
                index += diff;
            }
        }
        return new String(ans);
    }
    public String executeDecryption(String s, int d, int r){
        String format = formatting(s);

        for(int i = 0; i < r; i ++){
            format = decryption(format, d);
        }
        return format;
    }

    private String formatting(String s){
        char[] chars = new char[s.length()];

        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isLetterOrDigit(cur)) {
                if (Character.isUpperCase(cur)) {
                    chars[size++] = Character.toLowerCase(cur);
                } else {
                    chars[size++] = cur;
                }
            }
        }
        return new String(chars).trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the ciphertext you want to decrypt: ");
        String s = scanner.nextLine();
        System.out.println();
        int d, r;
        while (true) {
            System.out.println("Please enter your key (two integers separated by a space): ");
            if (scanner.hasNextInt()) {
                d = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    r = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Please enter the second integer.");
                    scanner.next();
                }
            } else {
                System.out.println("Please enter an integer.");
                scanner.next();
            }
        }

        System.out.println("Decrypting for you...");
        scanner.close();

         railFenceCipher test = new railFenceCipher();
        String result = test.executeDecryption(s, d, r);

        System.out.printf("Using a key of (%d, %d)%n", d, r);
        System.out.println("The plaintext after decryption is: " + result);
    }
}

