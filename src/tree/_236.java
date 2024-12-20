package tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #236. Lowest Common Ancestor of a Binary Tree
 * @Type:   binary tree
 * @Key Point:      dfs结构
 * @Description:    找LCA，即找给定的两个node的最近的共同祖先
 *              思路：每次call，return的结果是当前的root是不是p或q，如果是直接返回当前root，
 *              如果都不是，那就继续续向下找（根据左子树和右子树汇总），直到leaf（返null），
 *
 */
public class _236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;// 跳出条件

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){   // 如果left==null 说明找到底了也没有遇到 p，q 所以pq肯定都在右子树，返回右子树的结果
            return right;
        }else if(right == null){ // 如果right == null 说明pq都在左子树，返回左子树的结果
            return left;
        } else {
            return root;    // 如果左右都不为null 说明p q都找到了 return root
        }
    }
}
