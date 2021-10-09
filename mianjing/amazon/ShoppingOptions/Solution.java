package mianjing.amazon.ShoppingOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Amazon OA: Shopping Options
// array + sort + binarySearch
public class Solution {
    public int getNumberOfOptions(int[] priceOfJeans, int[] priceOfShoes, int[] priceOfSkirts, int[] priceOfTops,
            int dollars) {
        int count = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        List<Integer> l1 = new ArrayList<>();
        for (int a : priceOfJeans)
            for (int b : priceOfShoes)
                // map.put(map.getOrDefault(a+b, 0)+1);
                l1.add(a + b);
        List<Integer> l2 = new ArrayList<>();
        for (int c : priceOfSkirts)
            for (int d : priceOfTops)
                l2.add(c + d);
        Collections.sort(l1);
        Collections.sort(l2);
        // 速度慢，brute force up to O(n^4)
        // for (int a : l1)
        // for (int b : l2)
        // if (a + b <= dollars)
        // count++;

        // binary search代码
        for (int i = 0; i < l1.size(); i++) {
            int l = 0, r = l2.size() - 1, mid = -1;
            boolean flag = false;
            while (l < r) {
                mid = l + (r - l) / 2;
                if (l2.get(mid) <= dollars - l1.get(i)) {
                    // 从mid找分界线
                    while (mid < l2.size() && l2.get(mid) <= dollars - l1.get(i))
                        mid++;
                    mid--;
                    flag = true;
                    break;
                } else {
                    r = mid; // mid-1
                }
            }
            if (flag) {
                count += mid + 1;
                while (mid + 1 < l2.size() && l2.get(mid + 1) == l2.get(mid)) {
                    mid++;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] priceOfJeans = new int[] { 2, 3 };
        int[] priceOfShoes = new int[] { 4 };
        int[] priceOfSkirts = new int[] { 2, 3 };
        int[] priceOfTops = new int[] { 1, 2 };
        int dollars = 10;

        // int[] priceOfJeans = new int[] { 8, 1 };
        // int[] priceOfShoes = new int[] { 2 };
        // int[] priceOfSkirts = new int[] { 2, 5 };
        // int[] priceOfTops = new int[] { 4, 2 };
        // int dollars = 15;
        Solution sol = new Solution();
        System.out.println(sol.getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, dollars));
    }
}

// O(M logM) time, here M = size of these vectors = N^2
// time: O(N^2 log(N^2))