import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/28/6:12 PM
 * @Description:
 */
public class _004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums1) {
            pq.add(num);
        }
        for (int num: nums2) {
            pq.add(num);
        }
        int medianAt = (nums1.length + nums2.length) / 2;
        int len = nums1.length + nums2.length;
        boolean isOdd;
        if(len % 2 == 0){
            isOdd = false;
        }else{
            isOdd = true;
        }

        if(isOdd){
            while(medianAt > 0){
                pq.poll();
                medianAt--;
            }
            return (double) pq.poll();
        }else{
            while(medianAt > 1){
                pq.poll();
                medianAt--;
            }

            return (double) (pq.poll() + pq.poll()) / 2.0;
        }
    }
}
