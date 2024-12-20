package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/08/9:26 PM
 * @Description:
 */
public class _053 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum < 0) sum = 0;    // 只要前面累加的和小于零，说明拖后腿了，舍弃并归零
        }
        return max;
    }
}
