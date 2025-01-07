package array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #238. Product of Array Except Self
 * @Type: Array
 * @KeyPoint: prefix / suffix
 *
 * @Description: 
 * @RelevantProblems: 
 */
public class _238 {
    public int[] productExceptSelf0(int[] nums) {
        // 此数组存储nums当前位置数字左边所有数字的乘积（前缀乘积）
        int [] left = new int[nums.length];
        left[0] = 1;
        for( int i = 1; i < nums.length; i++ ){
            // 前缀乘积 = 上一个位置的前缀乘积 * 前一个位置的num
            left[i] = left[i-1] * nums[i-1];
        }

        // 此数组存储nums当前位置数字右边所有数字的乘积（后缀乘积）
        int [] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for( int i = nums.length - 2; i >= 0; i-- ){
            // 后缀乘积 = 下一个位置的后缀乘积 * 后一个位置的num
            right[i] = right[i+1] * nums[i+1];
        }


        int [] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i-- ){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    //  优化空间复杂度: 用ans存储前缀积，用int存储后缀积，并更新ans

    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int right = nums[ans.length-1];
        for(int i = nums.length - 2; i >= 0; i--){
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }
}
