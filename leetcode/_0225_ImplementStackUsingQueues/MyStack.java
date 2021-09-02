package leetcode._0225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

// S1 Deque is Queue?
// S2 两个queue
// S3 一个queue
// S2 两个queue

// two queues, push heavy
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) throw new RuntimeException();
        
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        
        q1 = q2;
        q2 = new LinkedList<>();
        
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        if (empty()) throw new RuntimeException();
        
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.peek();
        q2.offer(q1.poll());
        
        q1 = q2;
        q2 = new LinkedList<>();
        
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }
}

// time: push O(1), pop/top O(N);

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */