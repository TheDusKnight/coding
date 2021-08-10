package amazon.OptimalUtilization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// sort + two pointers
// Amazon OA: Amazon Prime Air / Optimal Utilization
class Solution2 {
    public List<List<Integer>> getPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {
        Collections.sort(a, (i, j) -> (i.get(1) - j.get(1)));
        Collections.sort(b, (i, j) -> (i.get(1) - j.get(1)));
        List<List<Integer>> res = new ArrayList<>();
        int aLen = a.size(), bLen = b.size();
        int l = 0, r = bLen - 1;
        int max = -1; // Integer.MIN_VALUE
        while (l < aLen && r >= 0) {
            int sum = a.get(l).get(1) + b.get(r).get(1);
            if (sum > target) { // sum在不大于target的情况下尽可能大
                r--;
                continue;
            }
            if (max <= sum) {
                if (max < sum) {
                    max = sum;
                    res.clear();
                }
                res.add(Arrays.asList(a.get(l).get(0), b.get(r).get(0)));
                // 把b重复的数都加到res里
                int idx = r;
                while (idx - 1 >= 0 && b.get(idx - 1).get(1) == b.get(idx).get(1)) {
                    res.add(Arrays.asList(a.get(l).get(0), b.get(idx-1).get(0)));
                    idx--;
                }
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        a.add(Arrays.asList(1,8));
        a.add(Arrays.asList(2,7));
        a.add(Arrays.asList(3,14));
        b.add(Arrays.asList(1,5));
        b.add(Arrays.asList(2,5));
        b.add(Arrays.asList(3,10));
        b.add(Arrays.asList(4,14));

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

        Solution2 sol = new Solution2();
        List<List<Integer>> res = sol.getPairs(a, b, 20);
        for (List<Integer> r : res) {
            System.out.println(r.get(0) + ", " + r.get(1));
        }
    }
}

// time: O(n*log(n)). n是a，b中size大的一方的size

