package graph;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #417. Pacific Atlantic Water Flow
 * @Type:   graph + bfs
 * @KeyPoint:       需要从边界（可以入海的grid）反向bfs，检查连通性； 不能对 m*n 的每个grid做bfs
 * @Description:
 * @RelevantProblems:   和numOfIsland思路不同
 */
public class _417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> result = new LinkedList<>();

        // Boolean matrix 维护了所有可以入海的格子
        boolean[][] checkPacific = new boolean[row][col];
        boolean[][] checkAtlantic = new boolean[row][col];

        // bfs队列
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        // 所有临海的格子都是true，并入队
        for (int i = 0; i < row; i++) {
            pQueue.add(new int[]{i, 0});
            checkPacific[i][0] = true;

            aQueue.add(new int[]{i, col - 1});
            checkAtlantic[i][col - 1] = true;
        }

        // 所有临海的格子都是true，并入队
        for (int j = 0; j < col; j++) {
            pQueue.add(new int[]{0, j});
            checkPacific[0][j] = true;

            aQueue.add(new int[]{row - 1, j});
            checkAtlantic[row - 1][j] = true;
        }

        // bfs调用，改变checkMatrix中的 true/false
        bfs(heights, pQueue, checkPacific);
        bfs(heights, aQueue, checkAtlantic);

        // Matrix取并集
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (checkPacific[i][j] && checkAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] checkList) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = heights.length;
        int col = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                int[] neighbor = new int[]{x, y};

                if (x < 0 || y < 0 || x >= row || y >= col ||
                        checkList[x][y] || heights[x][y] < heights[cur[0]][cur[1]]) {
                    continue;
                }
                checkList[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
