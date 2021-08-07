package leetcode._0973_KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.Random;

class Solution3 {
    int[][] points;
    int k;
    Random rand;
    int len;
    public int[][] kClosest(int[][] points, int k) {
        // cc
        this.points = points;
        this.k = k;
        rand = new Random();
        len = points.length;
        quickSelect(0, len-1);
        // 把k个左边的最小points输出
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void quickSelect(int l, int r) {
        // if (l > r) return; // 不需要return
        
        int pivot = l + rand.nextInt(r - l + 1);
        int pivotVal = points[pivot][0]*points[pivot][0]+points[pivot][1]*points[pivot][1];
        swap(pivot, r);
        int slow = l, fast = l;
        
        while (fast <= r) {
            int slowVal = points[slow][0]*points[slow][0]+points[slow][1]*points[slow][1];
            int fastVal = points[fast][0]*points[fast][0]+points[fast][1]*points[fast][1];
            if (slowVal < pivotVal) {
                slow++;
            } else if (fastVal < pivotVal) {
                swap(slow, fast);
                slow++;
            }
            fast++;
        }
        swap(slow, r);
        // k-1是k closest的index。如果slow == k-1说明包括slow（pivot）在内k个最小points在左边
        if (slow == k - 1) {
            return;
        } else if (slow < k) {
            quickSelect(slow+1, r);
        } else {
            quickSelect(l, slow-1);
        }
    }

    private void swap(int r, int l) {
        int[] tmp = points[r];
        points[r] = points[l];
        points[l] = tmp;
    }
}

// O(n ~ n^2)
