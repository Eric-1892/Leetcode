package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #543. Diameter of Binary Tree
 * @Type:   Binary tree
 * @Key Point:      dfs+递归遍历/ bfs+迭代遍历
 * @Description:    与找最大depth相似（#104） 在每一个局部根节点处将左右最大depth相加得到所谓的 Diameter
 *                  这题不适合用bfs迭代
 */
public class _543 {
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);

        max = Math.max(max, leftLength + rightLength);

        return Math.max(leftLength, rightLength) + 1;
    }
}
