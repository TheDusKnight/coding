package leetcode._0169_MajorityElement;
import java.util.*;

// brute froce O(n^2) -> hashMap O(n) -> sort O(n*log(n)) -> Boyer-Moore Voting Algorithm
// hashmap, can use sort as well
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // return condition
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}
