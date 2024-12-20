package string;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #5. Longest Palindromic Substring
 * @Type:   String
 * @Key Point:  回文
 * @Description: 不确定s的长度是奇数还是偶数：分两种情况遍历
 *                  从中间的i迭代向左右两边找
 *                 用全局变量存最值
 */
public class _005 {
    private int index;
    private int maxLen;
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;

        for(int i = 0; i < s.length() -1; i++){
            findP(s, i, i);
            findP(s, i, i+1);
        }
        return s.substring(index, index+maxLen);
    }
    private void findP(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            if(maxLen < r - l - 1){
                maxLen = r-l-1;
                index = l + 1;
            }
        }
    }
}
