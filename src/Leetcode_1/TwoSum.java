package Leetcode_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/26/5:03 PM
 * @Description:
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        // ||  key: value of number  ||  value: index  ||
        for(int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(target - nums[i])){
                int key = target - nums[i];
                return new int[]{i, numMap.get(key)};
            }
            numMap.put(nums[i], i);

        }
        return null;
    }
}
