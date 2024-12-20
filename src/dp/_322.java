package dp;

import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #322. Coin Change
 * @Type: DP
 * @KeyPoint:
 * @Description: 初始把dp填满amount+1的数值
 *               用dp[i]表示当前位置的最小次数，
 *               注意dp[0] = 0 是base case：if i==c, dp[i] = 0+1，即如果数值和面值相等时，dp[i]=1
 *               每次用dp[i] 和 dp[i-c] 比大小，小则更新dp[i]
 *               最后如果dp[amount] = amount+1 则说明无法凑出，返回-1
 *
 * @RelevantProblems:
 *                      416：硬币每个只能用一次
 *                      322：本题是硬币可以用多次，但找的是使用最少硬币数凑出目标值
 */
public class _322 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[] dp = new int[amount+1]; // dp[i] 表示凑出当前数额所需的最小硬币数
        Arrays.fill(dp,amount+1); // 所有位置初始化为amount+1 (初始化为false)
        dp[0] = 0; // base case: if i==c, dp[i] = 0+1

        for(int i = 1; i <= amount; i++){
            for(int c : coins){
                if(i - c >= 0){
                    dp[i] = Math.min(dp[i], dp[i-c]+1); // dp[i-c]+1表示用当前这个面值的一枚硬币就可以凑出当前amount，如果没有这个面值的，就只能维持原本的所需硬币数
                }
            }
        }
        if(dp[amount] == amount+1) return -1;
        else return dp[amount];
    }
}
