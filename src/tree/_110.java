package tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #110. Balanced Binary Tree
 * @Type:  Binary Tree dfs
 * @Key Point:  检验二叉树是否是Balanced Binary Tree（高度差不大于1）
 * @Description:    dfs思路： 以左右子树作为新的root，分别算左右子树的高度 返回：当前高度
 */
public class _110 {
    public boolean isBalanced(TreeNode root) {
        if(height(root) != -1 || root == null) return true;
        return false;
    }

    private int height(TreeNode root){
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        if(leftHeight == -1 || rightHeight == -1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
