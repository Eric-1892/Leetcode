package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Leetcode #39. Combination Sum
 * @Type:       Backtracking
 * @Key Point:  回溯+dfs
 * @Description: 找给定数组中，可以加权出目标值的组合（数组元素可重复）
 * @RelevantProblems: 与046的区别：此题需要去除组合重复（[2,3] 和 [3,2] 只留一个）
 * 所以需要引入curIndex（从curIndex开始循环），来保证新加入的元素不是左侧的元素（已经讨论过的元素）
 */
public class _039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, 0, cur, ans);
        return ans;
    }
    public void dfs(int[] candidates, int target, int curIndex, List<Integer> curList, List<List<Integer>> ans){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(curList)); // 这里一定要new，并copy cur的值，不能直接add(curList), 否则最终ans中全部是cur的引用
            return; // 找到满足targetSum的即可return，不用找到底，且继续找一定找不到了
        }
        for(int i = curIndex; i < candidates.length; i++){
            curList.add(candidates[i]);     // 向右找[2,2,2] -> [2,2,2,3]
            dfs(candidates, target - candidates[i], i, curList, ans); // 向下找 [2,2,2] ->[2,2,2,2]
            curList.remove(curList.size()-1); // 【回溯！！】维护cur，回溯一步 [2,2,2,2] -> [2,2,2]
        }
    }


    public static void main(String[] args) {
        _039 test = new _039();

        for (List<Integer> list : test.combinationSum(new int[]{2,3,6,7}, 7)) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println(); // 打印完一行后换行
        }
    }
}
