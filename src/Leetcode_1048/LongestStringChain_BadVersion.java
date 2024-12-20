package Leetcode_1048;

import Tool_Methods.StringLengthComparator;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/25/6:32 PM
 * @Description:
 */
public class LongestStringChain_BadVersion {
    private static int maxSize; // 用于记录最长路径的全局变量

    public static void main(String[] args) {
        LongestStringChain_BadVersion test = new LongestStringChain_BadVersion();
        String[] input1 = {"a","b","ba","bca","bda","bdca"};
        String[] input2 = {"abcd","dbqca"};
        System.out.println(test.longestStrChain(input1));
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new StringLengthComparator());
        System.out.println("Sorted Array (by string length ascending): " + Arrays.toString(words));
        maxSize = 1;
        int count;
        for (int i = 0; i < words.length; i++) {
            count = 1;
            helper(words, i, count);
        }
        return maxSize;
    }
    private void helper(String[] words, int cur, int count){
        // 更新最大size
        maxSize = Math.max(maxSize, count);

        if(cur >= words.length-1)   return; // 最后一个元素没得比

        for (int i = cur + 1; i < words.length; i++) {

            // 如果不含substring
            if(!containSubStr(words[cur], words[i]))   continue;
            // 如果不符合size<=1
            if(words[i].length() - words[cur].length() >= 2) return;
            // 如果符合
            System.out.println("(in)Now count is : " + (count+1));
            helper(words, i, count+1);
        }
    }
    private boolean containSubStr(String cur, String compareStr){
        if(compareStr.length() - cur.length() != 1) return false;
        // 比较
        for(int m = 0; m < compareStr.length(); m++){
            String subStr = compareStr.substring(0, m) + compareStr.substring(m+1, compareStr.length());
            System.out.println("Comparing: " + cur + " with " + compareStr + "-" + subStr);
            if(subStr.equals(cur)){
                System.out.println("Yes!: " + cur + " with " + compareStr);
                return true;
            }
        }
        return false;
    }
}
