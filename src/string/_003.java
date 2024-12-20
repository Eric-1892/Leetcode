package string;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #003
 * @Type:   String
 * @Key Point:  Sliding window
 * @Description: 快慢指针，当遇到重复字母时，必须移动i，直到删除重复（左侧的）字母，才能继续移动j
 *              Hashset.contains O(1)，这里并不为了用它去重
 */
public class _003 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;

        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

}
