package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/18/11:33 AM
 * @Description:
 */
public class _11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l < r){
            max = Math.max(max, (r-l) * Math.min(height[l], height[r]));
            if(height[r] > height[l]) l++;
            else r--;
        }
        return max;
    }
}
