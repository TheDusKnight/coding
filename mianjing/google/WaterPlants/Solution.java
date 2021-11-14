package mianjing.google.WaterPlants;

public class Solution {
    public int getMinSteps(int[] bowls, int capacity) {
        // cc

        int len = bowls.length, steps = 0;
        int size = capacity;
        for (int i = 0; i < len; i++) {
            if (size >= bowls[i]) {
                size -= bowls[i];
                steps += 1;
            } else {
                steps += i + i + 1;
                size = capacity;
                size -= bowls[i];
            }
        }

        return steps;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] bowls = {2, 4, 5, 1, 2};
        int[] bowls = {2, 6, 5, 1, 2};
        int capacity = 6;
        System.out.println(sol.getMinSteps(bowls, capacity));
    }
}
