package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #36. Valid Sudoku
 * @Type:
 * @Key Point:      set初始化时，不强制指定类型，
 *                  “string” + 1 允许string和int拼接
 *                  hashset.add() 如果add的是重复的item 返回false
 *
 * @Description:    这道题用字符串拼接，来标记同一行、同一列、同一个block中 是否有重复的拼接字符串（"row: " + num + i）
 */
public class _036 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board.length; j++){
                char num = board[i][j];
                if(num != '.'){
                    if(!seen.add("r" + i + num) ||
                        !seen.add("c" + j + num) ||
                        !seen.add("b" + i/3 + '-' + j/3 + num)){

                        return false;
                    }
                }
            }
        }
        return true;
    }
}
