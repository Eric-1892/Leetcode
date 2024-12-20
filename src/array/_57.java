package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/12:19 PM
 * @Description:
 */
public class _57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        for(int[] old: intervals){
            if(newInterval[0] > old[1]){ // 且原区间小，add原区间（不重合）
                result.add(old);
            }else if(newInterval[1] < old[0]){ // 且原区间大，add新区间（不重合）
                result.add(newInterval);
                newInterval = old;
            }else{                          // 剩下的就是重合情况，不管怎么重合，都取左右更大的范围
                newInterval[0] = Math.min(newInterval[0], old[0]);
                newInterval[1] = Math.max(newInterval[1], old[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
