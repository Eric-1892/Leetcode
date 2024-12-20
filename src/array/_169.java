package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/11:27 AM
 * @Description:
 */
public class _169 {
    public int majorityElement1(int[] nums) {
        int count = 0;
        int resultNum = 0;
        int result = nums[0];
//        if(nums.length == 1) return nums[0];

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                count ++;
                if(count > resultNum){
                    result = nums[i];
                    resultNum = count;
                }
            } else{
                count = 1;
            }
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) > nums.length / 2) return n;
        }
        return -1;
    }
}
