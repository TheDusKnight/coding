package leetcode._0017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        dfs(res, map, digits, 0, new StringBuilder());
        return res;
    }
    
    private void dfs(List<String> res, Map<Character, String> map, String digits, int idx, StringBuilder path) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }
        
        String cur = map.get(digits.charAt(idx)); // 找到当前需要遍历的string
        for (int i = 0; i < cur.length(); i++) {
            path.append(cur.charAt(i));
            dfs(res, map, digits, idx+1, path);
            path.setLength(path.length()-1);
        }
    }
}

// time: O(4^N). 4是map value的最大长度，N是input string的长度