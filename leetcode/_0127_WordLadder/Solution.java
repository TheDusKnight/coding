package leetcode._0127_WordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// One way bfs，如果是伞状用two way bfs在content fact层面有优化
// All the words in wordList are unique!
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // cc
        // if (beginWord.equals(endWord)) { // 不需要加因为leetcode说了beginWord != endWord
        //     return 2;
        // }
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
                        if (j != c && set.contains(next)) {
                            if (next.equals(endWord))
                                return minLen;
                            queue.offer(next);
                            set.remove(next); // set同时具有check exist和查环的功能
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

// n是dict的长度，k是单词的平均长度
// time: O(n + 26k*n) = O(n); space: O(n)