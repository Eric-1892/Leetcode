package dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #300. Longest Increasing Subsequence
 * @Type:
 * @KeyPoint:
 * @Description:
 * @RelevantProblems:
 */
public class _300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
