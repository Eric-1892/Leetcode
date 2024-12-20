package stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/31/10:15 PM
 * @Description:
 */
public class _150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(String s: tokens){
            if("+".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            }else if("-".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if("*".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            }else if("/".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
