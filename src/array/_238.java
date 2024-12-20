package array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/2:03 PM
 * @Description:
 */
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for(int i = 1; i < nums.length; i++){   // 算左半边乘积
            result[i] = nums[i-1] * result[i-1];
        }
        int r = 1;
        for(int i = nums.length - 2; i >=0; i--){ // 算右半边乘积
            r *= nums[i+1];
            result[i] *= r;     // 和左半边乘积相乘得到答案
        }
        return result;
    }
}
