package leetcode._0010_RegularExpressionMatching;

class Solution2 {
    // dfs + pruning
    public boolean isMatch(String s, String p) {
        // 注意s和p长度都可以是0
        if (s == null || p == null)
            return false;
        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return dfs(s, 0, p, 0, memo);
    }
    
    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] memo) {
        int sLen = s.length(), pLen = p.length();
        // 注意s到头p有可能不到头但依然valid，比如s="", p="a*"，但p到头s必须到头才算valid
        if (idxP == pLen) {
            return idxS == sLen;
        }
        if (memo[idxS][idxP] != null) {
            return memo[idxS][idxP];
        }
        
        if (idxP+1 == pLen || p.charAt(idxP+1) != '*') { // 非星结构没有分叉
            if (idxS < sLen && isMatch(s, idxS, p, idxP)) {
                boolean res = dfs(s, idxS+1, p, idxP+1, memo);
                memo[idxS][idxP] = res;
                return res;
            } else {
                memo[idxS][idxP] = false;
                return false;
            }
        } else {
            // 星结构第一次可以不match任何string，i下一层从idxS位置开始
            int i = idxS-1;
            // 当i == idxS-1不需要match
            while (i < sLen && (i == idxS-1 || isMatch(s, i, p, idxP))) {
                if (dfs(s, i+1, p, idxP+2, memo)) {
                    memo[idxS][idxP] = true;
                    return true;
                }
                i++;
            }
            memo[idxS][idxP] = false;
            return false;
        }
    }
    
    private boolean isMatch(String s, int idxS, String p, int idxP) {
        if (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS)) {
            return true;
        }
        return false;
    }
}

// time: O(m*n*m) = O((m^2)*n)