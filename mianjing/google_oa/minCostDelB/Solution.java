package mianjing.google_oa.minCostDelB;

// Google OA
// 删b, 给一个String S,  删首尾字母cost 1 删中间的字母cost 2, 问把b全部删掉的最小cost。
// 举个栗子: "abbaab" ->"abbaa" ->"bbaa" ->"baa"->"aa" ，最小cost为4
public class Solution {
    public int minCost(String s) {
        // cc

        int len = s.length();
        int[] dpLeft = new int[len];
        int[] dpRight = new int[len];
        dpLeft[0] = s.charAt(0) == 'b' ? 1 : 0;
        dpRight[len-1] = s.charAt(len-1) == 'b' ? 1 : 0;

        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c != 'b') {
                dpLeft[i] = dpLeft[i-1];
            } else {
                dpLeft[i] = Math.min(i+1, dpLeft[i-1]+2);
            }
        }
        // System.out.println(Arrays.toString(dpLeft));

        for (int i = len-2; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != 'b') {
                dpRight[i] = dpRight[i+1];
            } else {
                dpRight[i] = Math.min(len-i, dpRight[i+1]+2);
            }
        }
        // System.out.println(Arrays.toString(dpRight));

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != 'b') res = Math.min(res, dpLeft[i] + dpRight[i]);
            else {
                res = Math.min(res, Math.min((i-1 >= 0 ? dpLeft[i-1] : 0) + dpRight[i], (i+1 < len ? dpRight[i+1] : 0) + dpLeft[i]));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abba";
        // String s = "abbaab";
        // String s = "aabaa";
        // String s = "abbaaba";
        // String s = "bbb";
        // String s = "abbbaabaabbba";
        System.out.println(sol.minCost(s));
    }
}
