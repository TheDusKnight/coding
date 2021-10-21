package leetcode._0888_FairCandySwap;

import java.util.Arrays;

// sort
class Solution2 {
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
        
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        
        int left = 0, right = 0;
        while (left < n1 && right < n2) {
            if (sum1 - aliceSizes[left] + bobSizes[right] == sum2 - bobSizes[right] + aliceSizes[left])
                return new int[] {aliceSizes[left], bobSizes[right]};
            else if (sum1 - aliceSizes[left] + bobSizes[right] < sum2 - bobSizes[right] + aliceSizes[left])
                right++;
            else left++;
        }
        
        return null;
    }
}

// time: O(n*log(n)); space: O(1);
