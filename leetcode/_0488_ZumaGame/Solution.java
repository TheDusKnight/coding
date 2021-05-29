package leetcode._0488_ZumaGame;

import java.util.HashMap;

public class Solution {
    // dfs
    // 权值不为1，无法用bfs做
    int min;

    public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0 || hand == null || hand.length() == 0)
            return -1;
        min = hand.length() + 1; // min不可能比手上的球还多，从hang.length()+1开始更新min
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        dfs(board, map, 0);
        // 判断min是否被更新过
        // 建议加括号增加可读性
        return (min == hand.length() + 1) ? -1 : min;
    }

    private void dfs(String board, HashMap<Character, Integer> map, int used) {
        int len = board.length();
        if (len == 0) {
            if (min > used)
                min = used;
            return;
        }

        for (int i = 0; i < len; i++) {
            char c = board.charAt(i);
            Integer count = map.get(c);
            if (count == null) // 注意一定要check手上有没有对应的ball
                continue;
            // Add 1 ball
            if (i + 1 < len && board.charAt(i + 1) == c) {
                if (map.remove(c) - 1 > 0) {
                    map.put(c, count - 1);
                }
                // new board要改名字
                String newBoard = removeBalls(board, i - 1, i + 2);
                dfs(newBoard, map, used + 1);
                // Set back hand map
                map.put(c, count);
            } else if (count >= 2) { // Add 2 balls
                if (map.remove(c) - 2 > 0) {
                    map.put(c, count - 2);
                }
                String newBoard = removeBalls(board, i - 1, i + 1);
                dfs(newBoard, map, used + 2);
                // Set back hand map
                map.put(c, count);
            }
        }
    }

    private String removeBalls(String board, int left, int right) {
        int len = board.length();
        while (left >= 0 && right < len) {
            char c = board.charAt(left);
            int count = 0;
            int l = left;
            while (l >= 0 && board.charAt(l) == c) {
                l--;
                count++;
            }
            int r = right;
            while (r < len && board.charAt(r) == c) {
                r++;
                count++;
            }
            if (count >= 3) {
                left = l;
                right = r;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= left; i++) {
            sb.append(board.charAt(i));
        }
        for (int i = right; i < len; i++) {
            sb.append(board.charAt(i));
        }
        return sb.toString();
    }
}