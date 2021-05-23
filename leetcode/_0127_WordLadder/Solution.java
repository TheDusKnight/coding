package leetcode._0127_WordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// One way bfs
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 2;
        }
        Set<String> set = new HashSet<>();
        for (String word: wordList) {
            set.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int minLen = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    // 注意z也要包含
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        // String next = Arrays.toString(arr); 不正确,有中括号
                        String next = String.valueOf(arr);
                        // String next = new String(arr);
                        if (set.contains(next) && next.equals(endWord)) {
                            return minLen;
                        }
                        if (set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[i] = c;
                }
            }
            minLen++;
        }
        return 0; // 不存在转换关系
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> wordList = Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain");
        String beginWord = "ymain";
        String endWord = "oecij";
        System.out.println(sol.ladderLength(beginWord, endWord, wordList));
    }
}

// n是dict的长度
// time: O(n + 26k*n) = O(n); space: O(n)