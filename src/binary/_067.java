package binary;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #67. Add Binary
 * @Type:       Binary
 * @KeyPoint:       二进制计算 进位 、 用chatAt - '0' 来把char 转化为 int
 * @Description:
 * @RelevantProblems:
 */
public class _067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() -1;
        int j = b.length() -1;
        int carry = 0;

        while(i >= 0 || j >= 0){
            int sum = carry;    // 如果上次循环有进位 直接加到sum先
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';  // 把String中的char 转化为 int
            carry = sum > 1 ? 1 : 0;  // 进几     // 0 , 1 , 2 , 3 只有这四种结果，大于一需要进位
            sb.append(sum % 2);      // 余几
        }
        if(carry != 0) sb.append(carry);    // 最后一次进位
        return sb.reverse().toString(); // 反转 因为每次append先进去末尾
    }
}
