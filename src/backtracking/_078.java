package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/04/3:06 PM
 * @Description:
 */
public class _078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, cur, 0, ans);
        return ans;
    }
    public void dfs(int[] nums, List<Integer> cur, int i, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(nums, cur, i+1, ans);

        cur.remove(cur.size()-1);
        dfs(nums, cur, i+1, ans);
    }
}
