package tree_BST;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #230. Kth Smallest Element in a BST
 * @Type:       BST
 * @KeyPoint:   BST 中序遍历递增的性质
 * @Description:    找第kth小的node
 * @RelevantProblems:   #94 inorder traversal
 */
public class _230 {

    // 递归版本
    private int count = 0;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return result;
    }

    private void traversal(TreeNode root, int k){
        if(root == null) return;    // dfs跳出条件

        traversal(root.left, k);    // 左

        count++;                    // 根
        if(count == k) result = root.val;

        traversal(root.right, k);   // 右
    }

    // 递归版本 dfs + stack
    public int kthSmallest2(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;       // 左
            }
            root = stack.pop();
            count++;
            if (count == k) return root.val;    // 根

            root = root.right;          // 右
        }
        return -1;      // 结果必在while loop中 return，unless k is greater than expected
    }
}
