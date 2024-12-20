package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #542. 01 Matrix
 * @Type:       graph
 * @KeyPoint:   matrix + bfs
 * @Description: 找每个格子与0的最小距离   这题不适合在input上直接修改的情况下使用dfs，因为起点和相邻点状态不同
 * @RelevantProblems:   773：一个出发点   200：多个出发点  此题是多个出发点
 *                      此题：修改的是和入队格相邻的格子，而不是入队格，不能把所有起点格全都先入队
 *                          因此与200策略不同，需要先找到全部起始点，再bfs修改所有未处理（-1）的格子
 */
public class _542 {

    public int[][] updateMatrix(int[][] mat) {
            final int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 两层for loop 把所有1的点标为-1（表示未处理）
        // 同时把所有0的点入队 用于bfs
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] dir : dirs){
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];

                if(row < 0 || row >= mat.length
                || col < 0 || col >= mat[0].length
                || mat[row][col] != -1){    // 找所有的是 -1 的格子
                    continue;
                }
                mat[row][col] = mat[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{row,col});
            }
        }
        return mat;
    }
}
