package leetcode._0507_PerfectNumber;

class Solution {
    public boolean checkPerfectNumber(int num) {
        // cc
        if (num <= 1) return false;
        
        int count = 1;
        int i = 2;
        // 所有在sqrt(num)之后出现过的数字在前面都有对应
        for (i = 2; i * i < num; i++) {
            if (num % i == 0) {
                count+= i;
                count += num / i;
            }
        }
        if (i * i == 0) count += i;
        
        return count == num;
    }
}

// time: O(sqrt(n));
