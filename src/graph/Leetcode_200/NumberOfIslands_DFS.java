package graph.Leetcode_200;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/25/2:36 PM
 * @Description:
 */
public class NumberOfIslands_DFS {
    public static void main(String[] args) {
        NumberOfIslands_DFS test = new NumberOfIslands_DFS();
        char[][] input1 = {{'1','1','1','1','0'},{'1','1', '0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(test.numIslands(input1));
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0
        || j < 0
        || i >= grid.length
        || j >= grid[i].length
        || grid[i][j] != '1') // '0': 不是陆地  '*'：已经过
        {
            return;
        }

        grid[i][j] = '*'; // 标记已经过
        dfs(grid, i, j+1); // right
        dfs(grid, i, j-1); // left
        dfs(grid, i+1, j); // down
        dfs(grid, i-1, j); // up
    }
}
