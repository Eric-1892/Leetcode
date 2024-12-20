package tree;

import com.sun.source.tree.Tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #226. Invert Binary Tree
 * @Type:   Binary Tree
 * @Key Point:  dfs 遍历 反转树结构
 * @Description:    dfs + 递归 + 不用容器
 *                  dfs思路：在调用时通过赋值来对树结构进行反转  返回：input的root
 */
public class _226dfs {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
