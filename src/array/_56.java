package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/2:31 PM
 * @Description:
 */
public class _56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        // sort our intervals 按升序排列数组中的元素
        // Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int[] cur = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(cur[1] < intervals[i][0]){
                result.add(cur);
                cur = intervals[i];
            }else{
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        result.add(cur);
        return result.toArray(new int[result.size()][]);
    }
}
