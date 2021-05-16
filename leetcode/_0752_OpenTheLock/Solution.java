package leetcode._0752_OpenTheLock;

import java.util.*;

// BFS
class Solution {
    public int openLock(String[] deadends, String target) {
        // cc
        Set<String> deadList = new HashSet<>();
        for (String deadend : deadends) {
            deadList.add(deadend);
        }
        if (deadList.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        HashSet<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                List<String> nexts = converter(cur);
                for (String next : nexts) {
                    if (next.equals(target))
                        return minLen;

                    if (deadList.contains(next))
                        continue;

                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            minLen++;
        }
        // throw new RuntimeException("Target not find");
        return -1;
    }

    private static List<String> converter(String cur) {
        char[] tmp = cur.toCharArray();
        List<String> container = new ArrayList<>();

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == '9') {
                tmp[i] = '0';
                container.add(String.valueOf(tmp));
                tmp[i] = '8';
                container.add(String.valueOf(tmp));
                tmp[i] = '9';
            } else if (tmp[i] == '0') {
                tmp[i] = '9';
                container.add(String.valueOf(tmp));
                tmp[i] = '1';
                container.add(String.valueOf(tmp));
                tmp[i] = '0';
            } else {
                char change = tmp[i];
                tmp[i] = (char) (Character.getNumericValue(tmp[i] + 1) + '0');
                container.add(String.valueOf(tmp));
                tmp[i] = (char) (Character.getNumericValue(tmp[i] - 2) + '0');
                container.add(String.valueOf(tmp));
                tmp[i] = change;
            }
        }
        return container;
    }
}

// time: O(1)