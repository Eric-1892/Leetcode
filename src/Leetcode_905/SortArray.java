package Leetcode_905;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/28/2:57 PM
 * @Description:
 */
public class SortArray {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] % 2 != 0){
                while (left < right){
                    if(nums[right] % 2 == 0){
                        int swap = 0;
                        swap = nums[right];
                        nums[right] = nums[left];
                        nums[left] = swap;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return nums;
    }
}
