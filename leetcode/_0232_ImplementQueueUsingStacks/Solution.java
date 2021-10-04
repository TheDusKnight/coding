package leetcode._0232_ImplementQueueUsingStacks;
import java.util.Stack;

class MyQueue {
    // fields
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) throw new RuntimeException("msg");
        return stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (empty()) throw new RuntimeException("msg");
        return stackOut.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        helper();
        return stackOut.isEmpty();
    }
    
    private void helper() {
        if (stackOut.isEmpty()) { // 如果stackOut是empty，意味着什么都不用做，直接从stackOut拿值
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */