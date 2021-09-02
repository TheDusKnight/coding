package leetcode._0225_ImplementStackUsingQueues;
import java.util.LinkedList;
import java.util.Queue;

// S3 一个queue, push heavy
class MyStack2 {
    Queue<Integer> queue;
    int size;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue = new LinkedList<>();
        size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        size++; // 可以用queue.size() O(1)时间找到size
        
        int i = size;
        while (i-- > 1) {
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) throw new RuntimeException("msg");
        size--;
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if (empty()) throw new RuntimeException("msg");
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
