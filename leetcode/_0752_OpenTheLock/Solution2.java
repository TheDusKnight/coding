package leetcode._0752_OpenTheLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution2 {
    // 纯手写
    // bfs
    // target will not be in the list deadends
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String dead : deadends) {
            deadSet.add(dead);
        }
        // cc
        if (deadSet.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    char up, down;
                    if (tmp == '0') {
                        up = '1';
                        down = '9';
                    } else if (tmp == '9') {
                        up = '0';
                        down = '8';
                    } else {
                        int in = Character.getNumericValue(tmp);
                        up = (char)(in + 1 + '0');
                        down = (char)(in - 1 + '0');
                    }
                    arr[i] = up;
                    String before = String.valueOf(arr);
                    arr[i] = down;
                    String after = String.valueOf(arr);
                    // 根据题意不需要检查是否在deadSet，并且不需要检查是否visited
                    if (before.equals(target) || after.equals(target)) {
                        return minLen;
                    }
                    if (!deadSet.contains(before) && visited.add(before)) {
                        queue.offer(before);
                    }
                    if (!deadSet.contains(after) && visited.add(after)) {
                        queue.offer(after);
                    }
                    arr[i] = tmp;
                }
            }
            minLen++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String[] s = new String[] { "0201", "0101", "0102", "1212", "2002" };
        System.out.println(sol.openLock(s, "0202"));
    }
}
