package Leetcode_053;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/03/4:06 PM
 * @Description:
 */
public class _053DivideNConquer {
    public static int maxSubArray(int[] nums) {
        return findMaxSubArray(nums, 0, nums.length - 1);
    }
    private static int findMaxSubArray(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        int mid = (low + high) / 2;
        int leftMax = findMaxSubArray(nums, low, mid);
        int rightMax = findMaxSubArray(nums, mid + 1, high);
        int crossMax = findCrossMax(nums, low, mid, high);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    private static int findCrossMax(int[] nums, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
