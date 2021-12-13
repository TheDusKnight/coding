package leetcode._0126_WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 返回任意一条路径
// dfs + while loop
class WordLadderIII {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        // cc
        Set<String> dict = new HashSet<>();
        for (String word: wordList){
            dict.add(word);
        }
        Map<String, String> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String next = String.valueOf(arr);
                        if (!next.equals(cur) && dict.contains(next)) {
                            if (next.equals(endWord)) { // 找到一条路径立即返回
                                res.add(next);
                                graph.put(next, cur); // 忘记put
                                return recoverPath(res, graph, endWord, beginWord);
                            }
                            graph.put(next, cur);
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }
                    arr[i] = tmp;
                }
            }
        }
        return res;
    }
    
    private List<String> recoverPath(List<String> res, Map<String, String> graph,
                                               String cur, String end) {
        while (!cur.equals(end)) {
            String next = graph.get(cur);
            res.add(0, next);
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadderIII sol = new WordLadderIII();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(sol.findLadders(beginWord, endWord, wordList));
    }
}

// time: O(n + 26*n)
