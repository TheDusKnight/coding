package jianzhioffer.array._11;

// Binary search
public class Solution2 {
    public int minArray(int[] numbers) {
        if (numbers.length == 1)
            return numbers[0];

        int l = 0, r = numbers.length - 1, mid;
        // 因为题目说val有可能重复，所以不能判断
        // 这一步判断数组是否旋转过，即数组是否单调递，优化时间复杂度
        // if (numbers[r] > numbers[0])
        //     return numbers[0];

        while (l + 1 < r) { // 左右相邻
            mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid; // mid本身也有可能是最小值
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1; // mid本身不可能为最小值
            } else {
                r--; // 如果mid和r相等，最右边的val扔掉
            }
        }
        return Math.min(numbers[l], numbers[r]);
    }
}

// time: O(log(n)); space: O(1);
