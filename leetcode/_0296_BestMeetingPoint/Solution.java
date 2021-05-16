package leetcode._0296_BestMeetingPoint;
import java.util.*;

// bfs similar to LC317, 超时，以下为数学解
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        return getMin(X) + getMin(Y);
    }

    private int getMin(List<Integer> nums) {
        Collections.sort(nums);
        int res = 0;
        int mid = nums.get(nums.size() / 2);
        for (int n : nums) {
            res += Math.abs(n - mid);
        }
        return res;
    }
}