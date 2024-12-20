package tree;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #104. Maximum Depth of Binary Tree
 * @Type:   Binary tree
 * @Key Point:  DFS
 * @Description:    分别用迭代 和 递归 实现dfs
 *                  dfs递归思路： 以左右子树作为新的root，分别算左右子树的高度，返回：当前高度
 *                  dfs迭代思路： 两个stack，一个用于实现dfs，一个用于存储当前每个node的depth，value和node是一一对应且不会一直记录，
 *                              而是用于计算下一个迭代的value，用完就扔
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepthIterative(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> curMaxDepth = new Stack<>();

        stack.push(root);
        curMaxDepth.push(1);

        int max = 0;

        while(! stack.isEmpty()){
            TreeNode curRoot = stack.pop();
            int curDepth = curMaxDepth.pop();

            max = Math.max(max, curDepth);

            if(curRoot.right != null){
                stack.push(curRoot.right);
                curMaxDepth.push(curDepth + 1);
            }
            if(curRoot.left != null){
                stack.push(curRoot.left);
                curMaxDepth.push(curDepth + 1);
            }
        }

        return max;
    }
}
