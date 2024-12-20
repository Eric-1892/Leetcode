package binarySearch;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/12/3:28 PM
 * @Description: Binary Search 1. 找mid，根据情况判断继续在left side找，还是right side找
 */
public class _033 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            // left half is sorted
            if(nums[mid] >= nums[i]) {
                // 这两种情况下，target 都在 right half
                if (target > nums[mid] || target < nums[i]) {
                    // 更新左端点
                    i = mid + 1;
                // 否则， target 在 left half
                }else{
                    // 更新左端点
                    j = mid - 1;
                }
            // right half is sorted
            }else {
                if(target < nums[mid] || target > nums[j]){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }
        }
        return -1;
    }
}
