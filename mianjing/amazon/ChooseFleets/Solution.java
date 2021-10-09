package mianjing.amazon.ChooseFleets;

import java.util.Arrays;

// 数学归纳
public class Solution {
    public int[] chooseFleets(int[] vehicles) {
        // cc
        int[] res = new int[vehicles.length];
        int len = res.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 != 0)
                continue;
            res[i] = vehicles[i] / 4 + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] vehicles = new int[] {6,3,2};
        System.out.println(Arrays.toString(sol.chooseFleets(vehicles)));
    }
}
