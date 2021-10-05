package leetcode._0062_UniquePaths;

// recursion无剪枝
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
    
    // time: O(2^(n or m?)); space: O(n or m?)
}
