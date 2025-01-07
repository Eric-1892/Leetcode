package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #
 * @Type:
 * @KeyPoint:
 * @Description:
 * @RelevantProblems:
 */
public class _216 {
    static int[] nums = {1,2,3,4,5,6,7,8,9};

    protected void backtracking(
        int loop,
        int remain,
        int cur,
        LinkedList<Integer> comb,
        List<List<Integer>> ans
    ){
        if(remain == 0){
            if(comb.size() == loop){
                ans.add(new LinkedList<>(comb));
            }
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = cur; i < nums.length && remain >= nums[i]; i++){
            comb.add(nums[i]);
            backtracking(
                    loop,
                    remain - nums[i],
                    i+1,
                    comb,
                    ans
            );
            comb.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<>();

        this.backtracking(k, n, 0, comb, ans);
        return ans;
    }
}
