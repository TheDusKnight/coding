package leetcode._0844_BackspaceStringCompare;

// stack
// 有two pointer解法
class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) throw new IllegalArgumentException();
        if (s.length() == 0 && t.length() == 0) return true;
        
        String sClean = cleanString(s);
        String tClean = cleanString(t);
        
        return sClean.equals(tClean);
    }
    
    private String cleanString(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

// time: O(n+m); space: O(n+m);
