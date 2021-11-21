package leetcode;

public class IntervalTree {
    class IntervalTreeNode {
        IntervalTreeNode left;
        IntervalTreeNode right;
        int max;
        int start;
        int end;

        public InteverTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
