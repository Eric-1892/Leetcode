package graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #79. Word Search
 * @Type: graph(Matrix)
 * @KeyPoint: DFS
 * @Description: 以matrix中每个cell为起点进行DFS
 *  1.如何解决visited cell：每次进入dfs前把当前cell标记为“*”，结束dfs，返回前恢复原cell值
 *  2.
 * @RelevantProblems:
 */
public class _079 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){
        // 步出条件：当遍历了全部word中的字符后，即可跳出
        if(index == word.length()) return true;

        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || board[i][j] != word.charAt(index)){
            return false;
        }
        // 在进入dfs前保存当前字符，之后标记为visited
        char curChar = board[i][j];
        board[i][j] = '*';

        //dfs遍历
        boolean result = dfs(board, word, i-1, j, index+1) ||
                        dfs(board, word, i, j-1, index+1) ||
                        dfs(board, word, i+1, j, index+1) ||
                        dfs(board, word, i, j+1, index+1);

        // 进行完dfs后恢复matrix中原有的字符
        board[i][j] = curChar;
        return result;
    }
}
