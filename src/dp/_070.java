package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #70. Climbing Stairs
 * @Type: DP
 * @KeyPoint: 每次走1/2步，那么第n阶梯子的做法 = 到达n-1阶的走法 + 到达n-2阶的走法
 * @Description: base case：R1 = 1， R2 = 2 -> Rn = R(n-1) + R(n-2)
 * @RelevantProblems:
 */
public class _070 {
    // 递归解法 时间复杂度过高：O(2^n)
    public int climbStairs1(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }






    // 记忆 + 递归解法, 把已经计算过的结果存起来
    // 时间：O(n)
    // 空间: O(n)
    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs2(n, memo);
    }
    private int climbStairs2(int n, Map<Integer, Integer> memo){
        // base case
        if(n == 1) return 1;
        if(n == 2) return 2;
        // 如果还没算过，递归计算并存入map
        if(!memo.containsKey(n)){
            memo.put(n, climbStairs2(n-1, memo) + climbStairs2(n-2, memo));
        }
        // 已经算过直接从map里取值，不再计算
        return memo.get(n);
    }






    // 迭代 + 制表Tabulation，把计算结果按顺序存入数组
    // time: O(n)
    // space: O(n)
    public int climbStairs3(int n) {
        if(n == 1) return 1;

        int[]dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }







    // 迭代 + 优化空间制表，只存前后两个的结果
    // time: O(n)
    // space: O(1)
    public int climbStairs4(int n) {
        if(n==1) return 1;

        int R1 = 1;
        int R2 = 2;

        for(int i = 2; i < n; i++){
            int temp = R2;
            R2 = R1 + temp;
            R1 = temp;
        }
        return R2;
    }
}
