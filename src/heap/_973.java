package heap;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/28/4:57 PM
 * @Description:    pq可以存int[] 并且可以根据数组第i位上的元素进行排序
 */
public class _973 {
    public int[][] kClosest(int[][] points, int k) {
        // 以int[]第0个元素升序排列
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        for(int i = 0; i < points.length; i++){
            int sq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new int[]{sq, i});
        }

        int[][] result = new int[k][];

        for(int i = 0; i < k; i++){
            result[i] = points[pq.poll()[1]];
        }
        return result;
    }
}
