package leetcode._0278_FirstBadVersion;

// binary search 左右相邻做法
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) throw new RuntimeException("Invalid input");

        int left = 0, right = n, mid;
        while (left+1 < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // post processing
        if (isBadVersion(left)) return left;
        if (isBadVersion(right)) return right;
        throw new RuntimeException("No badversion found.");
    }
}