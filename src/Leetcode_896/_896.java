package Leetcode_896;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/29/10:43 AM
 * @Description:
 */
public class _896 {
    public boolean isMonotonic(int[] nums) {
        boolean in = false;
        boolean de = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {
                de = true;
            }
            if (nums[i + 1] - nums[i] > 0) {
                in = true;
            }
            if (in && de) {
                return false;
            }
        }
        return true;
    }
}
