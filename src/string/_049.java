package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #49. Group Anagrams
 * @Type:   String Anagram 同分异构
 * @Key Point:  判断/挑选与目标字符串具有相同字母的字符串 anagram： abc  cba
 * @Description:    利用对字符串进行排序 或 用字母表统计字母出现次数的方法 不适合用hashmap
 *                  当相同key对应多个value时，用Hashmap<String, List<String>> 的结构
 */
public class _049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            // 对于每一个String，建立字母表
            char[] chars = new char[26];
            for(char c : s.toCharArray()){
                // 每个字母出现时，对应的index上+1，用于统计映射的字母才出现的次数
                chars[c - 'a']++;
            }
            // 得到统计字母频次的字符串
            String key = String.valueOf(chars);
            // 字母出现相同频次的String被认为是同一组的（abc  cba）
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
