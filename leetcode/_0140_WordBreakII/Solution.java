package leetcode._0140_WordBreakII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// similar to valid ip address
// 亚麻原题！！
// TODO: trie!
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        boolean[] m = new boolean[len+1];
        Arrays.fill(m, true);
        HashSet<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }

        search(res, new StringBuilder(), s, 0, dict, m);
        return res;
    }

    private void search(List<String> res, StringBuilder path, String s, int idx, Set<String> dict, boolean m[]) {
        int len = s.length();
        if (idx == len) {
            res.add(path.toString());
            return;
        }

        int curSize = res.size();
        for (int i = idx + 1; i <= len; i++) {
            // 个人认为dfs的题要有for loop的条件是和for loop代码和index产生联系的时候
            // 如果只需要处理当前层逻辑，即每一层相互独立则for loop非必要
            String str = s.substring(idx, i);
            if (dict.contains(str) && m[i]) {
                int lenPath = path.length();
                if (lenPath == 0) {
                    path.append(str);
                } else {
                    path.append(" " + str);
                }

                search(res, path, s, i, dict, m);
                path.setLength(lenPath);
            }
        }
        // ?
        if (curSize == res.size()) {
            m[idx] = false;
        }
    }
}