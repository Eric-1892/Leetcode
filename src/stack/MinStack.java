package stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/31/11:12 PM
 * @Description:
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;  // 每次更新min时，把上次的min和新min一起入栈（两个元素总是一起入栈，一起出栈）
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop() == min){ // 当min出栈后，pop出上次的min 并设为min（两个元素总是一起入栈，一起出栈）
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
