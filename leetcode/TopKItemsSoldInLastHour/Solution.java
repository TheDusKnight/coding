package leetcode.TopKItemsSoldInLastHour;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Item {
    int id;
    Date time;
    
    public Item(int id) {
        this.id = id;
        Date d = new Date();
        this.time = d;
    }
}

// Amazon onsite 原题
public class Solution {
    Calendar cal; // 防止多线程问题
    Map<Integer, Item> map = new HashMap<>();

    public void addItem(Item i) {
        map.put(i.id, i);
    }

    public List<Item> getTopItems(Date timeGiven, int k) {
        List<Item> itemList = new ArrayList<>();
        cal = Calendar.getInstance();
        cal.setTime(timeGiven);
        cal.add(Calendar.HOUR, -1); // timeGiven的前一个小时
        Date oneHourBack = cal.getTime();

        // 这题必须用maxHeap，如果用minHeap要怎么保证取到k个？
        Queue<Item> maxHeap = new PriorityQueue<>((o1, o2) -> o2.time.compareTo(o1.time));
        for (int key: map.keySet()) maxHeap.offer(map.get(key));

        while (!maxHeap.isEmpty() && k > 0) { // check empty很重要
            Item t = maxHeap.poll();
            if (t.time.compareTo(timeGiven) == -1 && t.time.compareTo(oneHourBack) >= 0) {
                itemList.add(t);
                k--;
            }
        }

        return itemList;
    }
}
