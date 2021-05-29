package leetcode._0140_WordBreakII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // dfs for loop: similar to valid ip address
    // 亚麻原题
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
            // dfs使用for loop表示拼接
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