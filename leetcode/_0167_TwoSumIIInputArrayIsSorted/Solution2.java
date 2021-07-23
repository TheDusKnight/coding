package leetcode._0167_TwoSumIIInputArrayIsSorted;

public class Solution2 {
    // two pointers left, right同向。超时可能是因为没有很好的利用sort的特性
    public int[] twoSum(int[] numbers, int target) {
        // cc
        int l = 0, r = 1;
        while (l < r) { // 相邻
            int curSum = numbers[l] + numbers[r];
            if (curSum == target) {
                break;
            } else if (curSum < target) {
                if (r < numbers.length - 1)
                    r++;
                else
                    l++;
            } else {
                if (r > 0)
                    r--;
                else
                    l--;
            }
        }
        return new int[] { l + 1, r + 1 };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.twoSum(new int[] { 3, 24, 50, 79, 88, 150, 345 }, 200);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

// time: 大于O(n)因为r和l有可能往回走
