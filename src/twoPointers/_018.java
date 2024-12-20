package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/13/3:03 PM
 * @Description:
 */
public class _018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length -3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1;
                int r = nums.length-1;
                while(l < r){
                    long sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        ArrayList<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[l]);
                        sol.add(nums[r]);
                        ans.add(sol);
                        while(l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _018 test = new _018();
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        test.fourSum(nums, -294967296);
    }
}
