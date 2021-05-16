package leetcode._0038_CountAndSay;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = f(ans);
        }
        return ans;
    }
    
    private String f(String ans) {
        char c = ans.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < ans.length(); i++) {
            if (ans.charAt(i) != c) {
                sb.append(count).append(c);
                // reset
                c = ans.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        // 兜底因为if条件解决不了最后count重复数字
        sb.append(count).append(c);
        return sb.toString();
    }
}

// time: O(n)