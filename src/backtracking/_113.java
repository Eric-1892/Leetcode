package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #113. Path Sum II
 * @Type:
 * @Key Point:  回溯+dfs
 * @Description: 找从root到leaf的和加起来是给定值
 * @RelevantProblems: 与039，046区别： 113是进第二层dfs后再加，所以即使找到了解也要回溯； 039、046是进第二层dfs前加的，进dfs后找到解return即可
 * 会在第一层的后面回溯，而不是第二层dfs里回溯。这与树结构有关，因为树结构必须先add在比较
 */
public class _113 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        dfs(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root, int targetSum, int curSum, List<Integer> curList){
        if(root == null) return;

        curList.add(root.val);

        if(root.left == null && root.right == null && curSum + root.val == targetSum){
            result.add(new ArrayList<>(curList));
        }else{
            dfs(root.left, targetSum, curSum + root.val, curList);
            dfs(root.right, targetSum, curSum + root.val, curList);
        }
        curList.remove(curList.size()-1); // 回溯！！！
    }
}
