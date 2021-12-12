package leetcode._0269_AlienDictionary;

import java.util.Arrays;

// 拓扑排序
class Solution {
    private static final int N = 26;
    public String alienOrder(String[] words) {
        // cc
        
        boolean[][] graph = new boolean[N][N];
        int[] stMap = new int[N];
        buildGraph(words, graph, stMap);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (stMap[i] == 0)
                if (dfs(graph, stMap, sb, i))
                    return "";
        }
        
        return sb.reverse().toString();
    }
    
    private boolean dfs(boolean[][] graph, int[] stMap, StringBuilder sb, int i) {
        int status = stMap[i];
        if (status == 1) return true;
        if (status == 2) return false;
        
        stMap[i] = 1;
        for (int j = 0; j < N; j++) {
            if (graph[i][j]) { // 有connection说明status一定不为-1
                if (dfs(graph, stMap, sb, j)) return true;
            }
        }
        stMap[i] = 2;
        sb.append((char)(i + 'a')); // 忘记加进sb
        return false;
    }
    
    private void buildGraph(String[] words, boolean[][] graph, int[] stMap) {
        Arrays.fill(stMap, -1); // -1表示还不存在
        for (char c: words[0].toCharArray()) stMap[c - 'a'] = 0;
        for (int i = 1; i < words.length; i++) {
            for (char c: words[i].toCharArray()) stMap[c - 'a'] = 0;
            // 防止["abc","ab"]错误
            String w1 = words[i-1], w2 = words[i];
            if (!w1.equals(w2) && w1.startsWith(w2)) {
                Arrays.fill(stMap, 2);
                return;
            }
            
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    // 忘记转换
                    graph[c1 - 'a'][c2 - 'a'] = true;
                    break;
                }
            }
        }
    }
}

// time: O(V+E) = O(26+k); k是input words的长度
