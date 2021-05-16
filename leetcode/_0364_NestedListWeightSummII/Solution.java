package leetcode._0364_NestedListWeightSummII;
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

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // cc
        if (nestedList == null) return -1;
        
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger n : nestedList) {
            queue.offer(n);
        }
        
        // singelSum每层保留，意味着每次加sum都会加一遍之前所有从层的值
        int sum = 0, singleSum = 0, minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    singleSum += cur.getInteger();
                } else {
                    for (NestedInteger n : cur.getList()) {
                        queue.offer(n);
                    }
                }
            }
            minLen++;
            sum += singleSum;
        }
        return sum;
    }
}

// time: O(n)