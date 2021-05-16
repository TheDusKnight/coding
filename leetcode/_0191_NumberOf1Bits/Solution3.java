package leetcode._0191_NumberOf1Bits;

// input右移，check是否某一时刻出现0说明1找完了
public class Solution3 {
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        while (n != 0) {
            if ((n & mask) != 0) count++;
            n >>>= 1;
        }
        return count;
    }
}
