package leetcode;
import java.util.*;

public class IntervalTree {
    class IntervalTreeNode {
        IntervalTreeNode left;
        IntervalTreeNode right;
        int max;
        int start;
        int end;
    
        public IntervalTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            max = end;
        }
    }

    public IntervalTreeNode constructBST(int[][] intervals) {
        // cc
        // O(N*log(N))
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        // O(N)
        return constructBST(intervals, 0, intervals.length-1);
    }

    private IntervalTreeNode constructBST(int[][] intervals, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        IntervalTreeNode root = new IntervalTreeNode(intervals[mid][0], intervals[mid][1]);
        root.left = constructBST(intervals, start, mid-1);
        root.right = constructBST(intervals, mid+1, end);

        int childMax = 0;
        if (root.left != null && root.right != null) childMax = Math.max(root.left.max, root.right.max);
        else if (root.left != null) childMax = root.left.max;
        else if (root.right != null) childMax = root.right.max;
        root.max = Math.max(root.max, childMax);

        return root;
    }

    public boolean checkOverLap(int[][] intervals, int[] target) {
        // cc

        IntervalTreeNode root = constructBST(intervals);
        IntervalTreeNode cur = root;
        while (cur != null) { // while loop O(log(N))
            if (isOverLap(cur, target)) return true;
            if (cur.left != null && cur.left.max >= target[0]) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return false;
    }

    private boolean isOverLap(IntervalTreeNode cur, int[] target) {
        if (cur.start < target[0]) {
            if (cur.end < target[0]) return false;
            else return true;
        } else {
            if (target[1] < cur.start) return false;
            else return true; 
        }
    }

    // brute force O(N)
    // public boolean checkOverLap(int[][] intervals, int[] target) {
    //     // cc

    //     for (int[] interval: intervals) {
    //         if (target[0] < interval[0]) {
    //             if (target[1] > interval[0]) return true;
    //         } else {
    //             if (interval[1] > target[0]) return true;
    //         }
    //     }

    //     return false;
    // }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{19,30}, {17,25},
         {8,25}, {3,4}, {6,17}, {10,20}, {5,50}, {16,24}, {20,28}};
        int[] target = new int[] {31, 32};
        // int[] target = new int[] {1, 2};

        IntervalTree intervalTree = new IntervalTree();
        System.out.println(intervalTree.checkOverLap(intervals, target));
    }
}
