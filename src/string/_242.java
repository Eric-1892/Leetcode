package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Leetcode 242. Valid Anagram
 * @Type:   判断 Anagram 同分异构字符串
 * @Key Point:  3种方法
 * @Description:    1. hashmap
 *                  2. sort char array
 *                  3. char[26] 字母表
 */
public class _242 {
    public boolean isAnagram_Hashmap(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for(int i: map.values()){
            if(i != 0) return false;
        }
        return true;
    }

    public boolean isAnagram_Sort(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);
        // 比较对象用equals，Arrays有内置方法
        return Arrays.equals(ss,tt);
    }

    public boolean isAnagram_Alphabet(String s, String t) {
        char[] alphabet1 = new char[26];

        for(char c : s.toCharArray()){
            alphabet1[c - 'a']++;
        }

        char[] alphabet2 = new char[26];

        for(char c : t.toCharArray()){
            alphabet2[c - 'a']++;
        }

        return Arrays.equals(alphabet1,alphabet2);
    }

}
