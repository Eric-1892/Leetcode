package graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #733. Flood Fill
 * @Type:       graph
 * @KeyPoint:   Matrix + DFS
 * @Description: 在matrix里挑选一个格子，从这个格子向四周扩散
 * @RelevantProblems: 此题：
 *                      1. 单一起始点
 *                      2. 只需要考虑和单一起始点相邻的格子即可 （区别于 #200 islands需要找到全部起始点相邻的格子）
 *                      3. 用helper （区别于542 01 Matrix 需要遍历全图）
 */
public class _733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color){
            fill(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int initColor, int newColor){
        if(sr < 0 || sr >= image.length ||
                sc < 0 || sc >= image[0].length ||
                image[sr][sc] != initColor || image[sr][sc] == newColor){
            return; // 判断停止条件：1 位置出框， 2 和初始颜色不一致， 3 和新颜色一致（已经染过色了）
        }
        image[sr][sc] = newColor;
        fill(image, sr+1, sc, initColor, newColor);
        fill(image, sr, sc+1, initColor, newColor);
        fill(image, sr-1, sc, initColor, newColor);
        fill(image, sr, sc-1, initColor, newColor);
    }
}
