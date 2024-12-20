package Tool_Methods;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/25/1:14 PM
 * @Description:
 */
public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        // 比较字符串的长度，返回负数表示str1长度小于str2，返回正数表示str1长度大于str2，返回0表示长度相等
        return str1.length() - str2.length();
    }

    public static void main(String[] args) {
        String [] words = {"a", "abc", "edaeda", "ed"};
        Arrays.sort(words, new StringLengthComparator());
        System.out.println("Sorted Array (by string length ascending): " + Arrays.toString(words));
    }
}
