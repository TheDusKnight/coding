package leetcode._0155_MinStack;
import java.util.Stack;

// 一个stack
class MinStack2 {
    Stack<int[]> stack;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[] {x, x});
        } else {
            int min = Math.min(x, stack.peek()[1]);
            stack.push(new int[] {x, min});
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        } else throw new RuntimeException("msg");
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek()[0];
        } else throw new RuntimeException("msg");
    }
    
    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        } else throw new RuntimeException("msg");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
