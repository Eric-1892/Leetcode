package Leetcode_880;

import Tool_Methods.StringLengthComparator;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/27/3:21 PM
 * @Description:
 */
public class DecodedStringAtIndex {
    public static void main(String[] args) {
        String s = "a23";
        DecodedStringAtIndex decodedStringAtIndex = new DecodedStringAtIndex();
        System.out.println("result: " + decodedStringAtIndex.decodeAtIndex(s, 6));
    }
    public String decodeAtIndex(String s, int k) {
        long length = 0;
        int i = 0;

        while (length < k) {
            if (Character.isDigit(s.charAt(i))) {
                length *= s.charAt(i) - '0';
            } else {
                length++;
            }
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            if (Character.isDigit(s.charAt(j))) {
                length /= s.charAt(j) - '0';
                k %= length;
            } else {
                if (k == 0 || k == length) {
                    return Character.toString(s.charAt(j));
                }
                length--;
            }
        }

        return "";
    }

}
