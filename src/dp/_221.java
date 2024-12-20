package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/12/01/10:39 a.m.
 * @Description:
 */
public class _221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix == null || m == 0 || n == 0){
            return 0;
        }

        int edge = 0;

        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    edge = Math.max(edge, dp[i][j]);
                }
            }
        return edge * edge;
    }
}
