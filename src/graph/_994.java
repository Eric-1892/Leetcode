package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #994. Rotting Oranges
 * @Type:       matrix graph
 * @KeyPoint:   bfs
 * @Description:
 * @RelevantProblems: 此题需要从所有出发点同时开始bfs（层级搜索）参考102树结构
 *                      修改的是和入队格相邻的格子 而不是入队格（区别于200）
 */
public class _994 {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int fresh = 0;
        final int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        // 如果没有fresh 直接返回0
        if(fresh == 0) return 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int[]dir:dirs){
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];

                    if(row < 0 || row >= grid.length
                            || col < 0 || col >= grid[0].length
                            || grid[row][col] != 1) // 找所有的是 1 的格子
                        continue;
                    grid[row][col] = 2;
                    queue.offer(new int[]{row,col});
                    fresh--;
                }
            }
            count++;
            // 如果经过当前这个时间段，fresh没有了就可以跳出了
            if (fresh==0) return count;
        }
        // 如果bfs完还有fresh剩余，说明无法rot，返回-1
        if(fresh!=0) return -1;
        return count-1;
    }
}
