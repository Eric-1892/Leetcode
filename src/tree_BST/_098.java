package tree_BST;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #98. Validate Binary Search Tree
 * @Type:       BST
 * @KeyPoint:       BST inorder traversal (BST性质：中序遍历递增)
 * @Description:    验证BST   分别用 recursive 和 iterative 实现 inorder traversal
 * @RelevantProblems:
 */
public class _098 {
    // 递归版本
    private long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;   // base case （dfs的跳出条件）

        if(!isValidBST(root.left)) return false;    // 左

        if(root.val <= min) return false;       // 根
        min = root.val;

        if(!isValidBST(root.right)) return false;   // 右

        return true;
    }

    // 迭代版本 dfs + stack
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long min = Long.MIN_VALUE;

        while(root != null || !stack.isEmpty()){
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(root.val <= min) return false;
            min = root.val;

            root = root.right;
        }
        return true;
    }
}
