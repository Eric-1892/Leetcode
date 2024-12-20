package heap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #658. Find K Closest Elements
 * @Type:
 * @Key Point:
 * @Description:    这题因为是sorted array，不需要用pq； 也可以用左右指针向中间收缩
 *                  如果是unsorted array，可以sort+双指针； 或者pq
 */
public class _658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < arr.length ; i++){
            if(i < k){
                queue.add(arr[i]);
            }else if(Math.abs(arr[i] - x) < Math.abs(queue.peek() - x)){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        return result;
    }
}
