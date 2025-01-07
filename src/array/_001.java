package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #1. Two Sum
 * @Type: Array
 * @KeyPoint: 用HashMap存<目标值 ， 目标值index>，每次遍历时，把current存入Map，并查询Map中是否含有目标值
 * @Description:
 * @RelevantProblems:
 */
public class _001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
