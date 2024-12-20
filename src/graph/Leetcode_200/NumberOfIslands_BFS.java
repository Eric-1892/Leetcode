package graph.Leetcode_200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/25/4:11 PM
 * @Description:
 */
public class NumberOfIslands_BFS {

    public static void main(String[] args) {
        NumberOfIslands_BFS test = new NumberOfIslands_BFS();
        char[][] input1 = {{'1','1','1','1','0'},{'1','1', '0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(test.numIslands(input1));
    }
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '*';
                    queue.offer(new int[]{i,j});
                    bfs(grid, queue); // 找出与刚入队的这个格子（root）相邻的所有陆地格子，并标记为已经过
                }
            }
        }
        return count;
    }
    // 以队列头（root）为起点，找出所有相邻陆地,并标记已到达；
    // 其中，先找与root相邻的陆地格子，如有，入队，并从队列中的格子开始继续向下找，直到队列为空
    private void bfs(char[][]grid, Queue<int[]> queue){
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};  // 方向向量；

        while (!queue.isEmpty()){
            int[] cur = queue.poll(); // queue中，root的坐标

            for (int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1]; // 四个方向邻格的坐标
                if(x < 0
                || y < 0
                || x >= grid.length
                || y >= grid[0].length
                || grid[x][y] != '1'){
                    continue;   // 如果出界或 邻格不是陆地'1'，则跳过
                }
                // 否则 则说明找到了相邻的陆地格子，入队，并标记*
                grid[x][y] = '*';
                queue.offer(new int[] {x,y});
            }
        }
    }

}
