package leetcode._0269_AlienDictionary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 拓扑算法哥标准答案，["aba"] test case过不去
public class Solution2 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        HashMap<Character, List<Character>> graph = new HashMap<>();
        boolean hashPrefix = buildGraph(words, graph);
        if (hashPrefix) {
            return "";
        }
        HashMap<Character, Integer> statuses = new HashMap<Character, Integer>();
        StringBuilder path = new StringBuilder();
        for (Character start: graph.keySet()) {
            if (containsCycle(start, graph, statuses, path)) {
                return "";
            }
        }
        return path.reverse().toString();
    }
    
    private boolean buildGraph(String[] words, HashMap<Character, List<Character>> graph) {
        for (String word: words) {
            for (char ch: word.toCharArray()) {
                if (!graph.containsKey(ch)) {
                    graph.put(ch, new LinkedList<>());
                }
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len1 = word1.length();
            int len2 = word2.length();
            if (len1 > len2 && word1.startsWith(word2)) {
                return true;
            }
            
            int lenMin = Math.min(len1, len2);
            for (int j = 0; j < lenMin; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private boolean containsCycle(Character cur, HashMap<Character, List<Character>> graph, HashMap<Character, Integer> statuses, StringBuilder path) {
        if (cur == null)
            return false;
        Integer status = statuses.get(cur);
        if (status != null) {
            if (status == 1) {
                return true;
            } else if (status == 2) {
                return false;
            }
        }
        statuses.put(cur, 1);
        for (Character next: graph.get(cur)) {
            if (containsCycle(next, graph, statuses, path)) {
                return true;
            }
        }
        statuses.put(cur, 2);
        path.append(cur);
        return false;
    }
}
