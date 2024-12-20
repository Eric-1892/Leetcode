package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #226. Invert Binary Tree
 * @Type: Binary Tree
 * @Key Point:      bfs 遍历 反转树结构
 * @Description:    bfs + while loop + queue
 */
public class _226bfs {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer((node.right));
        }
        return root;
    }
}
