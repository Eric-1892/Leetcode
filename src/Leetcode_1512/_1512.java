package Leetcode_1512;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/02/11:59 PM
 * @Description:
 */
public class _1512 {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        // 统计数组中元素个数并存入map（不适用于累加计数2038）
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            result += calculateCombination(map.get(key), 2);
        }
        return result;
    }

    // 计算组合数 C(n, k)
    public static int calculateCombination(int n, int k) {
        if (k < 0 || k > n) {
            return 0; // 非法输入，组合数为0
        }

        if (k == 0 || k == n) {
            return 1; // 边界情况，组合数为1
        }

        // 使用循环计算组合数
        int numerator = 1;
        int denominator = 1;

        for (int i = 1; i <= k; i++) {
            numerator *= (n - i + 1); // n!
            denominator *= i; //
        }
        System.out.println("n" + n);
        System.out.println("k" + k);
        System.out.println("numerator" + numerator);
        System.out.println("denominator" + denominator);
        return numerator / denominator;
    }

    public static void main(String[] args) {
        _1512 test = new _1512();

        int [] nums = new int[]{1,2,3,1,1,3};

        test.calculateCombination(6,3);
    }
}
