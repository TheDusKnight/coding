package leetcode._0064_UniquePaths;

public class Solution {
    // recursion
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(51, 9));
    }

    // time: O(2^(n or m?)); space: O(n or m?)
}
