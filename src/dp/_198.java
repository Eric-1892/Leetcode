package dp;

import java.util.Arrays;

public class _198 {
    public int rob(int[] nums) {
        if( nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                dp[j] = Math.max(dp[j], nums[j] + dp[i]);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
