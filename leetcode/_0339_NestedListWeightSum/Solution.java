package leetcode._0339_NestedListWeightSum;
import java.util.*;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    NestedInteger();

    // Constructor initializes a single integer.
    NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// BFS
// LinkedIn 超高频题
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return -1;
        
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger n : nestedList) {
            queue.offer(n);
        }
        
        int minLen = 1;
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                NestedInteger tmp = queue.poll();
                if (tmp.isInteger()) {
                    sum += tmp.getInteger() * minLen;
                } else {
                    for (NestedInteger cur : tmp.getList()) {
                        queue.offer(cur);
                    }
                }
            }
            minLen++;
        }
        return sum;
    }
}

// time: O(n)