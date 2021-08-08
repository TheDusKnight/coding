package amazon.OptimalUtilization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// sort + two pointers
// Amazon OA
class Solution {
    public List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, (i, j) -> (i[1] - j[1]));
        Collections.sort(b, (i, j) -> (i[1] - j[1]));
        List<int[]> res = new ArrayList<>();
        int aLen = a.size(), bLen = b.size();
        int l = 0, r = bLen - 1;
        int max = -1; // Integer.MIN_VALUE
        while (l < aLen && r >= 0) {
            int sum = a.get(l)[1] + b.get(r)[1];
            if (sum > target) { // sum在不大于target的情况下尽可能大
                r--;
                continue;
            }
            if (max <= sum) {
                if (max < sum) {
                    max = sum;
                    res.clear();
                }
                res.add(new int[] { a.get(l)[0], b.get(r)[0] });
                // 把b重复的数都加到res里
                int idx = r;
                while (idx - 1 >= 0 && b.get(idx - 1)[1] == b.get(idx)[1]) {
                    res.add(new int[] { a.get(l)[0], b.get(idx-1)[0] });
                    idx--;
                }
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        a.add(new int[] { 1, 8 });
        a.add(new int[] { 2, 7 });
        a.add(new int[] { 3, 14 });
        b.add(new int[] { 1, 5 });
        b.add(new int[] { 2, 5 });
        b.add(new int[] { 3, 10 });
        b.add(new int[] { 4, 14 });

        // a.add(new int[] {1,3});
        // a.add(new int[] {2,5});
        // a.add(new int[] {3,7});
        // a.add(new int[] {4,10});
        // b.add(new int[] {1,2});
        // b.add(new int[] {2,3});
        // b.add(new int[] {3,4});
        // b.add(new int[] {4,5});

        // a.add(new int[] {1,8});
        // a.add(new int[] {2,15});
        // a.add(new int[] {3,9});
        // b.add(new int[] {1,8});
        // b.add(new int[] {2,11});
        // b.add(new int[] {3,12});

        Solution sol = new Solution();
        List<int[]> res = sol.getPairs(a, b, 20);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}

// time: O(n*log(n)). n是a，b中size大的一方的size
