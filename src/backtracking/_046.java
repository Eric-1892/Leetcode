package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #46. Permutations
 * @Type:   Backtracking
 * @Key Point:  回溯+dfs
 * @Description: 全排列
 * @RelevantProblems: 与039的区别：此题要求元素不可重复使用，所以需要去除已使用过的元素
 */
public class _046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, cur, ans);
        return ans;
    }
    public void dfs(int[] nums, List<Integer> cur, List<List<Integer>> ans){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int k = 0; k < nums.length; k++){
            if(!cur.contains(nums[k])){ // 不能重复
                cur.add(nums[k]);       // 向右找
                dfs(nums, cur, ans);    // 向下找
                cur.remove(cur.size()-1);   // 回溯！
            }
        }
    }
}
