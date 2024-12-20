package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #438. Find All Anagrams in a String
 * @Type:   String
 * @Key Point: sliding window 快慢指针
 * @Description:
 * !!!!!!!!!滑窗的size是动态变化的，而非固定!!!!!!!!!       （用counter来统计是否符合当前要求）
 * 可以理解为 当快慢指针圈住的字母中，集齐了p中的字母，就会进行一次查验，如果window的size正好是p的length，就是一个可行解
 * 随后慢指针会删除最左侧在p中的字母X，随后快指针右移直到再次找到X，进行下一次查验
 * 快慢指针做「相反加减操作」，保证统计数据的正确
 */
public class _438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // corner case
        if(p.length() > s.length()) return result;

        // 统计p中字母出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 计数器用map的大小，表示有多少种需要匹配的字母，value表示这种字母需要匹配的个数
        int counter = map.size();
        // 慢、快 指针
        int left = 0;
        int right = 0;

        // 移动快指针
        while(right < s.length()){
            char c = s.charAt(right);
            // 从0开始，每次扫描到map中的字母，就给这个字母需要匹配的值-1
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                // 如果值为0，说明这种字母匹配完成，给counter-1（少了一种需要匹配的字母）
                if(map.get(c) == 0) counter--;
            }
            right++;

            // 当所有需要匹配的字母都匹配完成了 那么counter就会被减到0
            while (counter == 0){
                // check possible solution
                if(right - left == p.length()){
                    result.add(left);
                }
                // 这里右移慢指针
                // 这里的逻辑是 与快指针做完全相反的操作
                // 可以理解为删掉最左边已经完成匹配的字母，并给map的value+1，表示该字母还需进行一次匹配
                // 这里的目的是为了继续找可行解
                // 举例来说 s = "abcdefabc" p = "abc" 那么移动慢指针意味着删掉了window中的a，当快指针找到下一个a时，counter再次归零，进行查验
                char cur = s.charAt(left);
                if(map.containsKey(cur)){
                    map.put(cur, map.get(cur) + 1);
                    if(map.get(cur) > 0) counter++;
                }
                left++;
            }
        }
        return result;
    }
}
