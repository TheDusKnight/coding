package leetcode._0045_JumpGameII;

// Greedy
class Solution3 {
    public int jump(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        int len = nums.length;
        // 忘加corner case
        if (len == 1) return 0;
        
        int preMax = 0;
        int curMax = 0;
        int jumps = 0;
        for (int i = 0; i < len; i++) {
            // curMax出界，实际需要再jump一次才能到达终点
            if (curMax >= len-1) return jumps+1;
            if (i > preMax) {
                // 走出preMax界限，jump数需要加一
                preMax = curMax;
                jumps++;
            }
            // 每次更新curMax，看能不能走得更远
            curMax = Math.max(curMax, i + nums[i]);
        }
        // 跳不到的情况
        return -1; 
    }
}
// time: O(n)
// space: O(1)