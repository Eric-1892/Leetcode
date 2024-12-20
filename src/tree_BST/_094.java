package tree_BST;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #94. Binary Tree Inorder Traversal
 * @Type:       Binary tree / BST
 * @KeyPoint:   BST中序遍历的递增性质
 * @Description:
 * @RelevantProblems:   #98验证有效BST
 */
public class _094 {

    // 递归版本
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root){
        if(root == null) return;

        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }

    // 迭代版本 DFS + stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;   // 找最左，边找边push
            }
            root = stack.pop();
            result.add(root.val);   // 根
            root = root.right;      // 右
        }
        return result;
    }
}
