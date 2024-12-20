package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/13/2:09 PM
 * @Description:
 */
public class _015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){ // 因为要留2个index给 left 和 right
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){ // 去除两个连续额重复nums[i]
                int target = 0 - nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r){
                    if(nums[l] + nums[r] == target){
                        ArrayList<Integer> sol = new ArrayList<>();
                        sol.add(nums[l]);
                        sol.add(nums[r]);
                        sol.add(nums[i]);
                        ans.add(sol);

                        while(l < r && nums[l] == nums[l+1]){ // 去除两个连续额重复nums[l]
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]){ // 去除两个连续额重复nums[r]
                            r--;
                        }
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
