package leetcode._0115_MinStack;
import java.util.*;

// 算法陪练10-06 min stack只保留重复的最小值做法
class MinStack {
    // fields
    private Stack<Integer> stackEle;
    private Stack<Integer> stackStore;
    

    /** initialize your data structure here. */
    public MinStack() {
        stackEle = new Stack<>();
        stackStore = new Stack<>();
    }
    
    public void push(int x) {
        stackEle.push(x);
        if (stackStore.isEmpty() || x <= stackStore.peek()) stackStore.push(x);
    }
    
    public void pop() { // 一般来讲应该有return
        // cc
        if (stackEle.isEmpty()) throw new IllegalArgumentException();
        if (stackEle.peek().equals(stackStore.peek())) stackStore.pop();
        stackEle.pop();
    }
    
    public int top() {
        // cc
        if (stackEle.isEmpty()) throw new IllegalArgumentException();
        return stackEle.peek();
    }
    
    public int getMin() {
        // cc
        if (stackEle.isEmpty()) throw new IllegalArgumentException();
        return stackStore.peek();
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