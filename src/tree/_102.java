package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #102. Binary Tree Level Order Traversal
 * @Type:       binary tree
 * @Key Point:   层级关系 bfs
 * @Description: bfs中的queue的size代表每一层的node个数
 */
public class _102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            // 每层的item列表
            List<Integer> list = new ArrayList<>();
            // 当前queue中有多少个node 说明这个level就有多少个node，确定循环次数
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                // 这里add node 不影响当前for循环的次数，add的都是下一level的node
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
