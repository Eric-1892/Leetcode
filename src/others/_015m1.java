package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/1:06 PM
 * @Description:
 */
public class _015m1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue; // 注意去重 和 边界

            int l = i + 1;
            int r = nums.length - 1;
            int target = 0 -nums[i];

            while(l < r){ // 注意加循环
                if(target == nums[l] + nums[r]){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    result.add(ans);
                    while(l < r && nums[l] == nums[l+1]) l++; // 注意去重 和 边界
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(target < nums[l] + nums[r]){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return  result;
    }
}
