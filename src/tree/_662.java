package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #662. Maximum Width of Binary Tree
 * @Type:   Binary Tree
 * @KeyPoint:       bfs + 层级关系
 * @Description:    找max-width between 2 leaf nodes
 * @RelevantProblems:
 */
public class _662 {
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Long> sequence = new LinkedList<>();
        sequence.offer(1L);

        while(!queue.isEmpty()){
            int curSize = queue.size();
            long left = Long.MAX_VALUE;
            long right = Long.MIN_VALUE;
            for(int i = 0; i < curSize; i++){
                TreeNode node = queue.poll();
                long seq = sequence.poll();

                left = Math.min(left, seq);
                right = Math.max(right, seq);
                result = Math.max(result, (int)(right-left+1));

                if(node.left != null){
                    queue.offer(node.left);
                    sequence.offer(2*seq);
                }
                if(node.right != null){
                    queue.offer((node.right));
                    sequence.offer(2*seq + 1);
                }
            }
        }
        return result;
    }
}
