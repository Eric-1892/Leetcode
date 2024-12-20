package tree_BST;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #235. Lowest Common Ancestor of a Binary Search Tree
 * @Type:       BST
 * @KeyPoint:   递归 dfs
 * @Description:    找BST的LCA（最近的共同祖先）
 * @RelevantProblems:   #236 与普通tree相比，BST由于结构特点（左小右大）可以优化为只找左、右子树，不需要全图找
 */
public class _235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 这不是跳出条件，只是boundary case

        if(root.val > p.val && root.val > q.val){ //p，q都在在左子树
            return lowestCommonAncestor(root.left,p,q);
        } else if(root.val < p.val && root.val < q.val){ //p，q都在在右子树
            return lowestCommonAncestor(root.right,p,q);
        } else{
            return root;
        }
    }
}
