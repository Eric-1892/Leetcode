package dp;

public class _152 {
    // 这道题关于DP： 由于构建subarray，需要数组中的元素连续，所以只需要维护num[i]和当前最值的关系，所以不需要构建dp[];
    // 由于需要考虑正负的问题，需要维护当前最大正数和最小负数
    //
     //
     //
     //
    //1.定义状态
    //  maxProduct[i]：以 nums[i] 结尾的子数组的最大乘积。
    //  minProduct[i]：以 nums[i] 结尾的子数组的最小乘积。
    //2.状态转移方程：
    //
    //  如果当前元素为 nums[i]，我们有三个选择：
    //  nums[i] 单独作为子数组的开始。
    //  nums[i] 与之前的最大乘积 maxProduct[i-1] 相乘。
    //  nums[i] 与之前的最小乘积 minProduct[i-1] 相乘（处理负数变正数）
    public int maxProduct(int[] nums) {
        int maxPositive = nums[0];
        int minNegative = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = minNegative;
                minNegative = maxPositive;
                maxPositive = temp;
            }
            // 只有当出现0时，才会出现nums[i] > nums[i] * maxPositive的情况，也就导致从新开启一个subarray
            maxPositive = Math.max(nums[i], nums[i] * maxPositive);
            minNegative = Math.min(nums[i], nums[i] * minNegative);

            res = Math.max(maxPositive, res);
        }
        return res;
    }
}
