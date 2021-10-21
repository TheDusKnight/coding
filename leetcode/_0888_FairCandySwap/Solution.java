package leetcode._0888_FairCandySwap;

// brute force
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // cc
        
        int sum1 = 0, sum2 = 0;
        int n1 = aliceSizes.length, n2 = bobSizes.length;
        for (int i = 0; i < n1; i++) {
            sum1 += aliceSizes[i];
        }
        for (int i = 0; i < n2; i++) {
            sum2 += bobSizes[i];
        }
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (sum1 - aliceSizes[i] + bobSizes[j] == sum2 - bobSizes[j] + aliceSizes[i])
                    return new int[] {aliceSizes[i], bobSizes[j]};
            }
        }
        
        return null;
    }
}

// time: O(n^2); space: O(1);
