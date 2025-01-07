package array;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #40. Combination Sum II
 * @Type:
 * @KeyPoint:
 * @Description:
 * @RelevantProblems:
 */
public class _040 {

    protected void backtracking(
            int remain,
            int cur,
            int[] candidates,
            LinkedList<Integer> comb,
            List<List<Integer>> ans
    ){
        if(remain == 0){
            ans.add(new LinkedList<>(comb));
            return;
        } else if (remain < 0) {
            return;
        }
        // 剪枝
        for(int i = cur; i < candidates.length && candidates[i] <= remain; i++){
            // 唯一和039不同的地方是每次递归的cur不是i 而是i+1；
            // 注意 如果array中有连续的相同元素则会导致重复结果， 需要去重
            // 这里i > cur 而不是i > 1, 是因为不只需要保证index不越界，还要保证比较的相邻元素是从cur开始而不是从0开始的
            if(i > cur && candidates[i] == candidates[i-1]) continue;
            comb.add(candidates[i]);
            backtracking(
                    remain-candidates[i],
                    i+1,
                    candidates,
                    comb,
                    ans
            );
            comb.removeLast();
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);

        this.backtracking(
                target,
                0,
                candidates,
                comb,
                ans
        );
        return ans;
    }
}
