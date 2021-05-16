package jianzhioffer.array._03;
import java.util.HashSet;
import java.util.Set;

// use hashset to deduplicate
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("Invalid");
    }
}

// time: n; space: n
