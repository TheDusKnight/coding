package leetcode._0895_MaximumFrequencyStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// hashmap + stack
class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, f);
        freq.put(val, f);
        Stack<Integer> stack = group.getOrDefault(f, new Stack<>());
        stack.push(val);
        group.put(f, stack);
    }
    
    public int pop() {
        int res = group.get(maxFreq).pop();
        if (group.get(maxFreq).size() == 0) maxFreq--;
        
        int newFreq = freq.get(res)-1;
        if (newFreq <= 0) freq.remove(res);
        else freq.put(res, newFreq);
        
        return res;
    }
}

// time: push O(1), pop O(1); space: O(N) N is the number of elements pushed.

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
