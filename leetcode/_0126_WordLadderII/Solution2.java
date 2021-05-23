package leetcode._0126_WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 自己纯手写
public class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        // cc
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // queue offer one, set remove one, 根据题意
        set.remove(beginWord);
        HashMap<String, List<String>> graph = new HashMap<>();
        boolean flag = false;
        while (!queue.isEmpty()) {
            Set<String> visitedThisLev = new HashSet<>();
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String next = String.valueOf(arr);
                        // 先不remove next等该层所有路径都保存后再把所有next删掉
                        if (!next.equals(cur) && set.contains(next)) {  
                            if (next.equals(endWord)) {
                                flag = true;
                            }
                            if (!visitedThisLev.contains(next)) {
                                List<String> one = new ArrayList<>();
                                one.add(cur);
                                graph.put(next, one);
                                queue.offer(next);
                                visitedThisLev.add(next);
                            } else {
                                List<String> one = graph.get(next);
                                one.add(cur);
                                graph.put(next, one);
                            }
                        }
                    }
                    arr[i] = tmp;
                }
            }
            set.removeAll(visitedThisLev);
            if (flag) {
                List<String> one = new ArrayList<>();
                one.add(endWord);
                search(result, one, endWord, beginWord, graph);
                return result;
            }
        }
        return result;
    }

    private void search(List<List<String>> res, List<String> one,
     String cur, String end, HashMap<String, List<String>> graph) {
         if (cur.equals(end)) {
             res.add(new ArrayList<String>(one));
             return;
         }
         List<String> next = graph.get(cur);
         for (String word: next) {
             one.add(0, word);
             search(res, one, word, end, graph);
             one.remove(0);
         }
     }
}
