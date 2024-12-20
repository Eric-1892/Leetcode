package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #100. Same Tree
 * @Type:   binary tree traversal
 * @Key Point:  dfs+递归 、 bfs+queue
 * @Description:    dfs思路：分别把左右子树带入， 返回：对下方所有子树判断的汇总结果
 */
public class _100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if (p == null || q == null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if(node1.val != node2.val) return false;

            if(node1.left != null && node2.left != null){
                q1.offer(node1.left);
                q2.offer(node2.left);
            } else if((node1.left != null && node2.left == null) || (node1.left == null && node2.left != null)){
                return false;
            }

            if(node1.right != null && node2.right != null){
                q1.offer(node1.right);
                q2.offer(node2.right);
            } else if((node1.right != null && node2.right == null) || (node1.right == null && node2.right != null)){
                return false;
            }
        }
        return true;
    }

    public boolean isSameTreeDfs(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTreeDfs(p.left, p.right) && isSameTreeDfs(q.right, q.right);
    }
}
