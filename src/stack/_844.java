package stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/19/11:06 PM
 * @Description:
 */
public class _844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        String result = ans.toString(); // 将StringBuilder 转换为 String


        for(int i = 0; i < t.length(); i++){
            if (t.charAt(i) == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(t.charAt(i));
            }
        }

        for(int i = 0; i < ans.length(); i++){
            if(!stack.isEmpty()) {
                if(ans.charAt(i) != stack.pop()) return false;
            }else {
                return false;
            }

        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
