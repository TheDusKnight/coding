package leetcode._0560_SubarraySumEqualsK;
import java.util.HashMap;
import java.util.Map;

// Prefix Sum + hashMap
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // sum为0初始化为1次否则[0, 0]区间sum无法初始化

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) { // [0, j]sum - [i, j]sum = [0, i]sum
                count += map.get(sum - k); // 在i比j小的情况下i可以在不同位置有相同的[0,i]sum，所以当j固定时，i变换位置生成不同subarray加到count次数上
            }
            // map put [0, i]区间的sum作为key，sum出现的次数作为value
            map.put(sum, map.getOrDefault(sum, 0) + 1); // getOrDefault的作用是为了防止出现数为0或负数
        }
        return count;
    }
}

// time: O(n); space: O(n)
