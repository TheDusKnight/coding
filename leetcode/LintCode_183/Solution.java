package leetcode.LintCode_183;

public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) return 0;

        long sum = 0;
        int longest = L[0];
        for (int i = 0; i < L.length; i++) {
            longest = Math.max(longest, L[i]);
            sum += L[i];
        }
        if (sum < k) return 0;

        int start = 1, end = Math.min(longest, (int)(sum/(long)k));
        while (start <= end) {
            int mid = start + (end - start) / 2; // 当前尝试的长度
            if (canCut(L, k, mid)) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return end;
    }

    private boolean canCut(int[] L, int k, int target) {
        long compare = 0;
        for (int l: L) {
            compare += l / target;
        }

        return compare >= k;
    }

    public static void main(String[] args) {
        // int[] L = {2147483644,2147483645,2147483646,2147483647};
        // int[] L = {232, 124, 456};
        int[] L = {1, 2, 3};
        int k = 7;
        Solution sol = new Solution();
        System.out.println(sol.woodCut(L, k));
    }
}

// time: O(log(L)*N) L = Math.min(longest, (int)(sum/(long)k)), N = length of L
