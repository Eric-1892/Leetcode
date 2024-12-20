package stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/19/8:40 PM
 * @Description:
 */
public class _20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else if (stack.isEmpty()){
                return false;
            } else {
                if (s.charAt(i) == ')') {
                    if (stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }else if (s.charAt(i) == ']') {
                    if (stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }else if (s.charAt(i) == '}') {
                    if (stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.size() != 0) return false;
        return true;
    }
}
