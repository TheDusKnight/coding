package leetcode._0320_GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // dfs, similar to subset
    // 答案出来leave node
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0)
            return res;
        dfs(res, word, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(List<String> res, String word, StringBuilder path, int idx, int val) {
        int pLen = path.length();
        int sLen = word.length();
        if (idx == sLen) {
            // 检查最后结果val是否大于0，如果是append val
            if (val > 0) {
                path.append(val);
            }
            res.add(path.toString());
            return;
        }

        // add char
        if (val > 0) {
            path.append(val + String.valueOf(word.charAt(idx)));
        } else {
            path.append(word.charAt(idx));
        }
        dfs(res, word, path, idx+1, 0);
        path.setLength(pLen);
        // add num
        dfs(res, word, path, idx+1, val+1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateAbbreviations("word"));
    }
}
