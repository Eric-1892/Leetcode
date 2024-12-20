package binary;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #191. Number of 1 Bits
 * @Type:           Binary
 * @KeyPoint:       位运算(无符号位运算) 来计算有多少个1
 * @Description:
 * @RelevantProblems:
 */
public class _191 {
    // you need to treat n as an unsigned value
    // 此处输入为10进制int，如果想输入2进制int 需要写成 0b1000 : 8

    //
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){      // java中，用二进制表示int 最高位的1/0表示正负，所以这里不能用n > 0（无法处理负数）
            n = n & (n-1); // 与运算是为了消除掉最后一个位的1  n:1100 -> 1000
            count++;
        }
        return count;
    }

    // 位运算方法
    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            count += (n&1); // n&1表示判断n的最低位是不是1，如果是，结果为1，不是则为0
            n = n>>>1;  // 无符号右移一位
        }
        return count;
    }
}
