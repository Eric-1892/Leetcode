package Leetcode_456;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/04/11:15 AM
 * @Description:
 */
public class _456_stack {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < second) return true;

            while(!stack.isEmpty() && stack.peek() < nums[i]){
                second = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
