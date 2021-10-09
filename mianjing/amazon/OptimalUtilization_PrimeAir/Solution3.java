package mianjing.amazon.OptimalUtilization_PrimeAir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 最终答案
public class Solution3 {
    public List<List<Integer>> routePairs(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        // cc

        Collections.sort(forwardRouteList, (i, j) -> (i.get(1) - j.get(1)));
        Collections.sort(returnRouteList, (i, j) -> (i.get(1) - j.get(1)));
        List<List<Integer>> res = new ArrayList<>();
        int fLen = forwardRouteList.size(), rLen = returnRouteList.size();
        int l = 0, r = rLen - 1;
        int max = -1; // Integer.MIN_VALUE?

        while (l < fLen && r >= 0) {
            int sum = forwardRouteList.get(l).get(1) + returnRouteList.get(r).get(1);
            if (sum > maxTravelDist) {
                r--;
                continue;
            }
            if (max <= sum) {
                if (max < sum) {
                    res.clear();
                    max = sum;
                }
                res.add(Arrays.asList(forwardRouteList.get(l).get(0), returnRouteList.get(r).get(0)));
                int idx = r;
                while (idx - 1 >= 0 && returnRouteList.get(idx - 1).get(1) == returnRouteList.get(idx).get(1)) {
                    res.add(Arrays.asList(forwardRouteList.get(l).get(0), returnRouteList.get(idx - 1).get(0)));
                    idx--;
                }
            }
            l++;
        }
        
        if (res.isEmpty()) {
            res.add(new ArrayList<>());
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> forwardRouteList = new ArrayList<>();
        List<List<Integer>> returnRouteList = new ArrayList<>();
        forwardRouteList.add(Arrays.asList(1,8));
        forwardRouteList.add(Arrays.asList(2,7));
        forwardRouteList.add(Arrays.asList(3,14));
        returnRouteList.add(Arrays.asList(1,5));
        returnRouteList.add(Arrays.asList(2,5));
        returnRouteList.add(Arrays.asList(3,10));
        returnRouteList.add(Arrays.asList(4,14));

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

        Solution3 sol = new Solution3();
        List<List<Integer>> res = sol.routePairs(20, forwardRouteList, returnRouteList);
        for (List<Integer> r : res) {
            System.out.println(r.get(0) + ", " + r.get(1));
        }
    }
}
