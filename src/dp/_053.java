package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #53. Maximum Subarray
 * @Type: DP
 * @KeyPoint:   用dp数组来表示以nums[i]为结尾的任何子数组的最大和，
 *              每次用dp[i-1] + nums[i]来判断nums[i]是否参与构成新的最大和
 *              如果相加结果比nums[i] 本身大，那么更新dp[i] = dp[i-1] + nums[i]，
 *              否则                              dp[i] = nums[i]，意味着以nums[i]为结尾的最大子数组和为他本身，重新开头
 *
 * @Description: 找数组中子数组的最大和
 * @RelevantProblems:
 */
public class _053 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i< nums.length; i++){
            // 判断dp[i]应该存相加的的结果，还是以nums[i]重新开头
            dp[i]= Math.max(nums[i] + dp[i-1], nums[i]);
            // 更新最终结果
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
