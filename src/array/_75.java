package array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/3:35 PM
 * @Description:
 */
public class _75 {
    public void sortColors(int[] nums) {
        int nextFor0 = 0;
        int nextFor2 = nums.length -1;
        int i = 0; // 从头遍历
        while(i <= nextFor2){
            if(nums[i] == 2){ // 如果遍历到2，放到末尾
                swap(nums, i, nextFor2);
                nextFor2--;   //  挪到下一个放2的位置
            }else if(nums[i] == 0){ // 如果遍历到0，放到开头
                swap(nums, i, nextFor0);
                nextFor0++;     // 挪到下一个放0的位置
                i++;
            }else{          // 如果遍历到1，不管他
                swap(nums, i, nextFor0);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
