package leetcode._0220_ContainsDuplicateIII;

import java.util.TreeSet;

public class Solution2 {
    // bst + sliding window
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // cc
        
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            // set remove, add, search是O(log(k))因为最多有t个元素
            if (i > k) {
                set.remove(Long.valueOf(nums[i-k-1])); // O(log(k))
            }
            // 通过解不等式易知区间内的valid值必须小于nums[i]+t大于nums[i]-t
            // valid值小于nums[i]+t但尽可能大所以使用TreeSet的floor
            Long floor = set.floor((long) nums[i] + t); // O(log(k))
            // 不能将直接将int转成long否则可能越界！！
            if (floor != null && floor >= (long) nums[i] - t)
                return true;
            // 下面的代码和上面效果的一样
            // Long ceiling = set.ceiling((long)nums[i] - t);
            // if (ceiling != null && ceiling <= nums[i] + t)
            //     return true;
            set.add(Long.valueOf(nums[i])); // O(log(k))
        }
        return false;
    }
}

// time: O(n*log(k)); space: O(log(k))
