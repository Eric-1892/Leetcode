package Leetcode_030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/29/2:59 PM
 * @Description:
 */
public class _030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        // Create a map to store the counts of each word in the words array
        // 统计数组中元素个数并存入map（不适用于累加计数2038）
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int strSize = s.length();
        int wordsNum = words.length;
        int wordLen = words[0].length();

        for(int i = 0; i < wordLen; i++){
            int start = i;
            int count = 0;
            Map<String, Integer> cur = new HashMap<>();

            for(int j = i; j <= strSize - wordLen; j = j + wordLen){
                String word = s.substring(j, j + wordLen);
                if(map.containsKey(word)){
                    cur.put(word, cur.getOrDefault(word, 0) + 1);
                    count++;

                    while(cur.get(word) > map.get(word)){
                        String startWord = s.substring(start, start+wordLen);
                        cur.put(startWord, cur.get(startWord) - 1);
                        count--;
                        start = start + wordLen;
                    }

                    if(count == wordsNum){
                        result.add(start);
                        String startWord = s.substring(start, start+wordLen);
                        cur.put(startWord, cur.get(startWord) - 1);
                        count--;
                        start = start + wordLen;
                    }
                }else{
                    start = j + wordLen;
                    cur.clear();
                    count = 0;
                }
            }
        }
        return result;
    }
}
