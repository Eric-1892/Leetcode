package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/11/01/3:11 PM
 * @Description: Next Greater Element I
 */
public class _496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap();
        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for(int j = 0; j < nums1.length; j++){
            ans[j] = map.getOrDefault(nums1[j], -1);
        }
        return ans;
    }
}
