package graph;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #310. Minimum Height Trees
 * @Type:
 * @KeyPoint:       1.找到初始的叶子节点
 *                  2.剥离叶子节点，直到剩下最多两个节点
 * @Description:    为了找到树的最小高度树（MHTs），我们可以利用拓扑排序的思想，
 *                  类似于Kahn算法来解决这个问题。这种方法通过逐步移除叶子节点来缩小树，最终留下的节点即为MHT的根节点
 *                  ** 目的是 ** 找最中心的node（1或2个），返回中心点node，即找到了MHT的root
 *
 *                  O(n)
 * @RelevantProblems:
 */
public class _310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        // 构建图
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 找到初始的叶子节点
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 剥离叶子节点，直到剩下最多两个节点
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);

                // 如果剪枝后，leaf的根节点变成了leaf节点，则加入newLeave集合
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
