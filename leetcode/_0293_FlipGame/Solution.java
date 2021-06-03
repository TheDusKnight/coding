package leetcode._0293_FlipGame;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        if (currentState == null || currentState.length() == 0)
            return res;
        char[] cur = currentState.toCharArray();
        for (int i = 0; i < cur.length-1; i++) {
            if (cur[i] == '+' && cur[i+1] == '+') {
                cur[i] = '-';
                cur[i+1] = '-';
                res.add(String.valueOf(cur));
                cur[i] = '+';
                cur[i+1] = '+';
            }
        }
        return res;
    }
}