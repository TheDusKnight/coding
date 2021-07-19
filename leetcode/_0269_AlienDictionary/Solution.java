package leetcode._0269_AlienDictionary;

import java.util.ArrayList;
import java.util.List;

// 拓扑，["z","z"] test case过不去
public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        if (words.length == 1)
            return words[0];
        
        List<Character>[] graph = new List[26];
        // hasPrefix表示，有前缀的时候，return true
        // 就是words[i]是words[i-1]的前缀的特殊例子（不包含本身），这种情况要return "";
        boolean hashPrefix = buildGraph(words, graph);
        if (hashPrefix) return "";
        StringBuilder sb = new StringBuilder();
        char[] statusMap = new char[26];
        for (int i = 0; i < 26; i++) {
            if (graph[i].size() > 0) {
                if (!dfs(graph, i, statusMap, sb)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }
    
    private boolean buildGraph(String[] words, List<Character>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
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
                    if (!graph[ch1-'a'].contains(ch2)) {
                        graph[ch1-'a'].add(ch2);
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(List<Character>[] graph, int cur, char[] statusMap, StringBuilder sb) {
        int status = statusMap[cur];
        if (status == 1) {
            return false;
        }
        if (status == 2) {
            return true;
        }
        
        statusMap[cur] = 1;
        List<Character> nexts = graph[cur];
        for (Character next: nexts) {
            if (!dfs(graph, next-'a', statusMap, sb)) {
                return false;
            }
        }
        statusMap[cur] = 2;
        sb.append((char)(cur+'a'));
        return true;
    }
}

// time: O(V+E) = O(26+k); k是input words的长度

