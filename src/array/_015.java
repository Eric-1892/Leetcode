package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #15. 3Sum
 * @Type: Array
 * @KeyPoint: two pointers
 * @Description:
 * @RelevantProblems: #167. Two Sum II - Input Array Is Sorted
 */
public class _015 {
    public List<List<Integer>> threeSum(int[] nums) {
        // sorted array
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        // 跳出条件：cur > 0 || 循环结束
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 如果cur和cur+1相等 则出现重复
            if (i == 0 || nums[i] != nums[i - 1]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int index, List<List<Integer>> res) {
        int left = index + 1;
        int right = nums.length - 1;

        while (left < right) {
            if(nums[left] + nums[right] == 0){
                res.add(Arrays.asList(nums[index], nums[left], nums[right]));
                left++;
                right--;
                // 如果cur和cur+1相等 则出现重复
                while (left < right && nums[left] == nums[left + 1]) left++;
            } else if (nums[left] + nums[right] < 0){
                left++;
            } else {
                right--;
            }
        }
    }
}
