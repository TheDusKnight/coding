package leetcode._0126_WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 自己纯手写
class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // cc
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s: wordList) {
            set.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        boolean flag = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> visitedThisLevel = new HashSet<>();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    for (char j = 'a'; j < 'z'; j++) {
                        chars[i] = j;
                        String next = String.valueOf(chars);
                        if (j != c && set.contains(next)) {
                            if (next.equals(endWord))
                                flag = true;
                            
                            if (!visitedThisLevel.contains(next)) {
                                List<String> one = new ArrayList<>();
                                one.add(cur);
                                graph.put(next, one);
                                visitedThisLevel.add(next);
                                queue.offer(next);
                            } else {
                                List<String> one = graph.get(next);
                                one.add(cur);
                                graph.put(next, one);
                            }
                        }
                    }
                    chars[i] = c;
                }
            }
            set.removeAll(visitedThisLevel);
            
            if (flag) {
                List<String> one = new LinkedList<>();
                one.add(endWord);
                search(res, one, endWord, beginWord, graph);
                return res;
            }
        }
        return res;
    }
    
    private void search(List<List<String>> res, List<String> one, String cur, String end, Map<String, List<String>> graph) {
        if (cur.equals(end)) {
            res.add(new LinkedList<>(one));
            return;
        }
        
        List<String> next = graph.get(cur);
        for (String s: next) {
            one.add(0, s);
            search(res, one, s, end, graph);
            one.remove(0);
        }
    }
}