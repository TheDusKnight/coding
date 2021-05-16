package leetcode._0155_MinStack;
import java.util.Stack;

// Two stacks
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) minStack.push(x);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            int out = stack.pop();
            if (out == minStack.peek()) minStack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else throw new RuntimeException("msg");
    }
    
    public int getMin() {
        if (!stack.isEmpty()) {
            return minStack.peek();
        } else {
            throw new RuntimeException("msg");
        }
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
