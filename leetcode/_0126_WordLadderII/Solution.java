package leetcode._0126_WordLadderII;

import java.util.*;

// 先bfs一边找最短路径一边反向存路径到hashmap，找到最短路径后通过dfs从end出发找所有能到达begin的路径
// 正着bfs搜最短路径，反向存hashmap
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0)
            return res;

        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        // 用来做bfs的queue
        Queue<String> queue = new LinkedList<>();
        // 用来存边对应关系的hashmap
        HashMap<String, List<String>> graph = new HashMap<>();
        queue.offer(beginWord);
        // 检查是否找到最短路径，但到找一条还不够，要把该层所有的最短路径都找到
        boolean flag = false;
        while (!queue.isEmpty()) {
            Set<String> visitedThisLev = new HashSet<>();
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char cc[] = cur.toCharArray();
                for (int i = 0; i < cc.length; i++) {
                    char temp = cc[i];
                    // 开始转换
                    for (char c = 'a'; c < 'z'; c++) {
                        cc[i] = c;
                        String str = String.valueOf(cc);
                        if (c != temp && wordSet.contains(str)) {
                            // Find end word
                            if (str.equals(endWord)) {
                                flag = true;
                            }

                            // 一个node的下一层可能有多个child nodes，查看是否visit
                            if (!visitedThisLev.contains(str)) {
                                List<String> one = new ArrayList<String>();
                                one.add(cur);
                                graph.put(str, one);
                                queue.offer(str);
                                visitedThisLev.add(str);
                            } else {
                                List<String> one = graph.get(str);
                                one.add(cur);
                                graph.put(str, one);
                            }
                        }
                    }
                    cc[i] = temp;
                }
            }
            wordSet.removeAll(visitedThisLev);
            // 每层过后check flag是否为true
            if (flag) {
                List<String> one = new LinkedList<String>();
                one.add(endWord);
                search(res, one, endWord, beginWord, graph);
                return res;
            }
        }
        // 没找到
        return res;

    }

    // 从endword找到beginword的所有path
    private void search(List<List<String>> res, List<String> one, String cur, String end,
            HashMap<String, List<String>> graph) {
        if (cur.equals(end)) {
            // deep copy
            res.add(new LinkedList<String>(one));
            return;
        }

        List<String> next = graph.get(cur);
        for (String n : next) {
            // 因为map是反着存，res要倒过来
            one.add(0, n);
            search(res, one, n, end, graph);
            // 回溯
            one.remove(0);
        }
    }
}