package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #409. Longest Palindrome
 * @Type:   String
 * @Key Point: hashmap遍历
 * @Description: 判断奇偶数；
 */
public class _409 {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        boolean single = false;
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() % 2 == 1) single = true;
            count += (entry.getValue() / 2) * 2;
        }
        if(single){
            return count +1;
        }else{
            return count;
        }
    }
}
