package Leetcode_1048;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/26/4:44 PM
 * @Description:
 */
public class LongestStringChain_DP {
    public int longestStrChain(String[] words) {
        // Lambda表达式排序， a-b: 升序     b-a: 降序
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int max_chain = 0;
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev_word = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev_word)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev_word) + 1));
                }
            }
            max_chain = Math.max(max_chain, dp.get(word));
        }
        return max_chain;
    }
    public static void main(String[] args) {
        LongestStringChain_DP longestStringChainDP = new LongestStringChain_DP();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result = longestStringChainDP.longestStrChain(words);
        System.out.println("Longest string chain length: " + result);
    }
}
