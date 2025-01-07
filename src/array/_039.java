package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #39. Combination Sum
 * @Type: Array; Backtracking
 * @KeyPoint:
 * @Description:
 * @RelevantProblems:
 */
public class _039 {
    // 定义LinkedList是为了可以removeLast
    protected void backtracking(
            LinkedList<Integer> comb,
            int[] candidates,
            int remain,
            int cur,
            List<List<Integer>> ans
    ){
        if(remain == 0){
            ans.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }
        // 注意i从cur开始，为了去重，不再引入前序元素
        for(int i = cur; i < candidates.length; i++){
            // 剪枝：如果candidates升序排列，当remain小于candidates[i],直接跳出循环
            if(candidates[i] > remain){
                break;
            }
            comb.add(candidates[i]);
            backtracking(
                    comb,
                    candidates,
                    remain - candidates[i],
                    i,
                    ans
            );
            // 回溯
            comb.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<>();
        // 如果剪枝，必须先sort
        Arrays.sort(candidates);
        this.backtracking(comb, candidates, target, 0, ans);

        return ans;
    }



    public static void main(String[] args) {
        _039 test = new _039();
        System.out.println(test.combinationSum(new int[]{3,4,5},8));

    }
}
