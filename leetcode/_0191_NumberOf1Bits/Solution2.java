package leetcode._0191_NumberOf1Bits;

// mask左移
public class Solution2 {
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask << i & n) != 0) count++;
        }
        return count;
    }
}
