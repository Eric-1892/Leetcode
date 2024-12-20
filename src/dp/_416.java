package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #416. Partition Equal Subset Sum
 * @Type:
 * @KeyPoint:
 * @Description: 两个子数组和相等，即sum为偶数，且sum/2 可以被=相加得出
 *
 * @RelevantProblems:
 *                      416：本题，硬币每个只能用一次
 *                      322：硬币可以用多次，但找的是使用最少硬币数凑出目标值
 */
public class _416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int target = sum/2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true; //base case, 当cursum-num ==0时，说明此硬币的面值一定可以凑出cursum

        // 由于硬币只能用一次，我们需要把硬币放在外层循环
        for(int coin: nums){
            // 用target值反向推导，防止硬币被复用
            for( int curSum = target; curSum > 0; curSum--){
                // 2种情况得到True
                //  1.自己面值本身
                //  2. 一直可行的curSum+自己本身的面值
                if(curSum - coin == 0){ //当cursum-num ==0时，说明此硬币的面值就是cursum，一定可以凑出cursum
                    dp[curSum] = true;
                } else if (curSum - coin > 0) { // 保证讨论的是正值curSum
                    dp[curSum] = dp[curSum] || dp[curSum-coin]; // 如果dp[curSum-coin]这个sum已经被证实可以凑出来，那么cursum也可以用过curcoin被凑出来
                }
            }
        }
        return dp[target];
    }
}
