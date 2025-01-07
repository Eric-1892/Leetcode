package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #57. Insert Interval
 * @Type: Array
 * @KeyPoint:
 * @Description:
 * @RelevantProblems:
 */
public class _057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // case 1: 插入部分与当前区间不重叠（插入左 > 当前右）：直接add
        while(i < n && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        // case 2: 插入区间与当前部分有重叠（插入右 > 当前左 且已知 插入左 <= 当前右）: 合并区间(更新new的左右界) (可能涉及多个区间的合并)
        while(i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // case3: 直接add剩余未被合并区间
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
