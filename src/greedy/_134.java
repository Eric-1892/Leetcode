package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/18/9:51 PM
 * @Description:
 */
public class _134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    // gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        int[] diff = new int[gas.length];
        int sum = 0;
        for(int i = 0; i < gas.length; i++){
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if(sum < 0) return -1;
        int count = 0;
        int result = 0;
        for(int i = 0; i < diff.length; i++){
            count += diff[i];
            if(count < 0){
                count = 0;
                result = i+1;
            }
        }
        return result;
    }
}
