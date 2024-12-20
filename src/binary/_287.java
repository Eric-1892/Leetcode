package binary;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #287. Find the Duplicate Number
 * @Type:       Binary
 * @KeyPoint:
 * @Description:        有比如 1，2，3，4，5 五个数字 存在size为 6 的array里，其中有一个重复的数字，要求不改变input，且 Space O(1)
 * @RelevantProblems:
 */
public class _287 {
    // binary search: 因为数字正好是从1到n的数字 而size是n+1 所以可以用二分法定位重复元素在哪
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;

        while (low < high){
            int mid = low + (high-low) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid) count++;
            }
            if(count <= mid) low = mid+1;
            else high = mid;
        }
        return low;
    }

    // bit 运算 （没看懂）
    public static int findDuplicate_bit2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }

        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }
}
