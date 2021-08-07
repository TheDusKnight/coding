package leetcode._0973_KClosestPointsToOrigin;

import java.util.Arrays;

// 改写Comparator sort
// Amazon OA
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> ( a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]) );
        return Arrays.copyOfRange(points, 0, k);
    }
}

// time: O(N*log(N)); Space: O(1)
