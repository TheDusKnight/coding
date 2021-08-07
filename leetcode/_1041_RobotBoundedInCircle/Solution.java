package leetcode._1041_RobotBoundedInCircle;

// Amazon onsite
// one pass
class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 上右下左
    public boolean isRobotBounded(String instructions) {
        // cc
        int[] loc = new int[2];
        int dir = 0;
        
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'R') {
                // dir = dir == 3 ? 0 : dir+1;
                dir = (dir + 1) % 4;
            } else if (instructions.charAt(i) == 'L') {
                // dir = dir == 0 ? 3 : dir-1;
                dir = (dir + 3) % 4;
            } else {
                loc[0] += DIRECTIONS[dir][0];
                loc[1] += DIRECTIONS[dir][1];
            }
        }
        return ((loc[0] == 0 && loc[1] == 0) || dir != 0);
    }
}

// time: O(n); space: O(1)
// If the robot doesn't face north at the end of the first cycle, then that's the limit cycle trajectory.
