package math;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #13. Roman to Integer
 * @Type:   Math
 * @Key Point:      hashmap 初始化要先new，再put
 * @Description:    比较第i项 和 第i+1项
 */
public class _013 {
    private HashMap<Character, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result -= map.get(s.charAt(i));
            }else{
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}
