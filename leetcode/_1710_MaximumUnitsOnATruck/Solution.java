package leetcode._1710_MaximumUnitsOnATruck;

import java.util.Arrays;

// Greedy
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // cc
        int count = 0;
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        for (int[] boxType: boxTypes) {
            int curCount = Math.min(truckSize, boxType[0]);
            count += curCount * boxType[1];
            truckSize -= curCount;
            if (truckSize == 0)
                break;
        }
        return count;
    }
}
