package leetcode._0278_FirstBadVersion;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// binary search
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // cc
        
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) end = mid-1;
            else start = mid+1;
        }
        
        if (start <= n) return start;
        // start跑出界还没找到
        throw new RuntimeException("No bad version");
    }
}