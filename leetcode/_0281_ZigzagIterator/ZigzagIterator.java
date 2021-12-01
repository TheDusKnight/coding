package leetcode._0281_ZigzagIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// iterator + queue
public class ZigzagIterator {
    Iterator<Integer> v1Iter, v2Iter;
    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // cc
        
        v1Iter = v1.iterator();
        v2Iter = v2.iterator();
        queue = new LinkedList<>();
        // 没有check null和empty结果报错
        if (v1 != null && !v1.isEmpty()) queue.offer(v1Iter);
        if (v2 != null && !v2.isEmpty()) queue.offer(v2Iter);
    }

    public int next() {
        if (!hasNext()) throw new RuntimeException("no next ele");
        
        Iterator<Integer> curIter = queue.poll();
        int ret = curIter.next();
        if (curIter.hasNext()) queue.offer(curIter);
        
        return ret;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

// time: O(1) init, O(1) next(), O(1) hasNext();
// space: O(1);

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
