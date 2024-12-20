package twoPointers;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/13/2:02 PM
 * @Description:
 */
public class _125_use_char_array {
    public boolean isPalindrome(String s) {
        // 创建一个字符数组来存储处理后的字符
        char[] chars = new char[s.length()];
        int size = 0;
        // 遍历原始字符串，处理非字母数字字符和大写字母
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

        int i = 0;
        int j = size - 1;
        // 检查回文串
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
