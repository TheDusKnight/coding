package leetcode._0127_WordLadder;

import java.util.*;

// One way bfs, could be improve
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // cc
        if (wordList == null || wordList.size() == 0)
            return 0;

        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                char[] words = cur.toCharArray();
                for (int i = 0; i < words.length; i++) {
                    char tmp = words[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        words[i] = j;
                        // String midWord = Arrays.toString(words); 有中括号
                        String midWord = String.valueOf(words);
                        // String midWord = new String(words);
                        if (!midWord.equals(cur) && set.contains(midWord)) {
                            // return condition
                            if (midWord.equals(endWord))
                                return minLen + 1;

                            queue.offer(midWord);
                            set.remove(midWord); // 去重
                        }
                    }
                    words[i] = tmp;
                }
            }
            minLen++;
        }
        return 0; // 不存在转换关系
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(sol.ladderLength(beginWord, endWord, wordList));
    }
}
// time: O(V + E) -> O(N + 25*k) -> O(N) k is the length of longest word in dict
// space: O(N)