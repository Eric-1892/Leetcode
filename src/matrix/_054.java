package matrix;

import Tool_Methods._binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #54. Spiral Matrix
 * @Type: Matrix
 * @Key Point: boundary switch
 * @Description: 每个方向一个for loop，用四个index指向当前的上下左右界
 */
public class _054 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bot = matrix.length - 1;

        while (right >= left && bot >= top){

            // move to right
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            // move down
            for(int i = top; i <= bot; i++){
                result.add(matrix[i][right]);
            }
            right--;

            // move to left
            // 这里的if是为了确定是否下方还有一行的空间用来向左
            if(bot >= top){
                for(int i= right; i >= left; i--){
                    result.add(matrix[bot][i]);
                }
                bot--;
            }

            // move up
            // 这里的if是为了确定是否左侧还有一列的空间用来向上
            if(right >= left){
                for(int i = bot; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
