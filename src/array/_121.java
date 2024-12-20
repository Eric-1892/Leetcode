package array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/16/6:15 PM
 * @Description:
 */
public class _121 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int min = 100000;
        int maxProfile = 0;

        for (int p : prices) {
            min = Math.min(min, p);
            maxProfile = Math.max(maxProfile, p - min);
        }
        return maxProfile;
    }
}
