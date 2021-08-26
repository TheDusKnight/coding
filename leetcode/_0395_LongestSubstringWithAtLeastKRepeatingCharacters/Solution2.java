package leetcode._0395_LongestSubstringWithAtLeastKRepeatingCharacters;

// divide and conquer
class Solution2 {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length(), k);
    }
    
    private int dfs(String s, int start, int end, int k) {
        // if (end < k) return 0; // 可以不加
        
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++) // countMap不包含end
            countMap[s.charAt(i) - 'a']++;
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue; // 说明当前index不用劈
            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) midNext++; // 拉开一段距离，中间所有invalid的letter都不看
            return Math.max(dfs(s, start, mid, k), dfs(s, midNext, end, k));
        }
        // for loop一路continue说明所有letter都合法
        return (end - start);
    }
}

// time: O(n^2); space: O(n) for recursive call stack;
