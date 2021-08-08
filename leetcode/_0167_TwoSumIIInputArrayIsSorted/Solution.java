package leetcode._0167_TwoSumIIInputArrayIsSorted;

public class Solution {
    // two pointers left right
    public int[] twoSum(int[] numbers, int target) {
        // cc
        
        int l = 0, r = numbers.length-1;
        // 相邻逻辑。如果是左右相等逻辑那么跳出while loop一定是break造成的，因为题意说一定存在solution，如果可能不存在那么需要check一下结果是否valid
        while (l + 1 < r) {
            int curSum = numbers[l] + numbers[r];
            if (curSum == target) {
                break;
            } else if (curSum < target) {
                l++;
            } else {
                r--;
            }
        }
        // 如果break那么l和r一定是要找的两个点
        // 如果while loop结束没有break那么说明没找到，但是根据题意，一定存在solution，所以只能是没有遍历到的相邻的两个点
        // 不需要做post-processing，直接输出结果
        return new int[]{l+1, r+1};
    }
}

// time: O(n)