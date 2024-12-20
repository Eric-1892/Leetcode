package stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/19/10:48 PM
 * @Description: 232
 */
class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
