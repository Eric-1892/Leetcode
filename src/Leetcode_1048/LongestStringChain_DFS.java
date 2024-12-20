package Leetcode_1048;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/26/12:51 AM
 * @Description:
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain_DFS {
    public int longestStrChain(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();

        for (String word : words) {
            wordSet.add(word);      // 利用 hashset 去重
        }

        int maxLength = 0;
        for (String word : words) {
            int chainLength = dfs(word, wordSet, memo);
            maxLength = Math.max(maxLength, chainLength);
        }

        return maxLength;
    }
    private int dfs(String word, Set<String> wordSet, Map<String, Integer> memo) {
        // 如果字典里没有， 则说明当前String的这个substring不在链上，返回0（当找到底时，“”会从这里跳出）
        if (!wordSet.contains(word)) {
            return 0;
        }
        // 如果已经记录过当前substring可以连通的最大长度，则直接取值
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        // 从root开始 最大可达长度为1
        int maxChain = 1;
        // 找当前String的所有可能的substring，以当前String为root 对所有substring进行DFS，直到单字母String的substring为“”为止
        for (int i = 0; i < word.length(); i++) {
            String nextWord = word.substring(0, i) + word.substring(i + 1);
            maxChain = Math.max(maxChain, 1 + dfs(nextWord, wordSet, memo));
        }
        memo.put(word, maxChain);
        return maxChain;
    }

    public static void main(String[] args) {
        LongestStringChain_DFS longestStringChainDFS = new LongestStringChain_DFS();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result = longestStringChainDFS.longestStrChain(words);
        System.out.println("Longest string chain length: " + result);
    }
}

