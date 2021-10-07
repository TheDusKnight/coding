package leetcode._0716_MaxStack;

import java.util.Stack;

// stack ood
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek())
            maxStack.push(x);
    }
    
    public int pop() {
        if (stack.isEmpty()) throw new RuntimeException();
        int pop = stack.pop();
        if (pop == maxStack.peek()) maxStack.pop();
        return pop;
    }
    
    public int top() {
        if (stack.isEmpty()) throw new RuntimeException();
        return stack.peek();
    }
    
    public int peekMax() {
        if (stack.isEmpty()) throw new RuntimeException();
        return maxStack.peek();
    }
    // popMax() O(N)
    public int popMax() { // min stack没有 popMin()
        if (stack.isEmpty()) throw new RuntimeException();
        
        int pop = maxStack.pop();
        Stack<Integer> tmp = new Stack<>();
        while (stack.peek() != pop) {
            tmp.push(stack.pop());
        } 
        stack.pop();
        
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        
        return pop;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */