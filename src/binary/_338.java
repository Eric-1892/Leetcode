package binary;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #338. Counting Bits
 * @Type:       Binary
 * @KeyPoint:   位运算
 * @Description:        算每个十进制数字对应的二进制数字有几个1
 *                      用DP的思想做
 * @RelevantProblems:
 */
public class _338 {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 1; i <= n; i++){
            result[i] = result[i >> 1] + (i & 1); //等效于  result[i] =  result[i/2] + (i % 2)
        }                   //  result[i >> 1] 右移一位： 8: 1000 >> 4: 100 相当于除以2
                            //  i & 1 相当于 i % 2     check最低位是不是1，如果是 就+1补回来
                            // dp 根据前面的结果算后面的结果
        return result;
    }
}
