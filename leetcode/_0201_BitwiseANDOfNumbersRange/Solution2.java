package leetcode._0201_BitwiseANDOfNumbersRange;

// bit.问题等价于找到left和right bit形式最大common prefix
class Solution2 {
    public int rangeBitwiseAnd(int left, int right) {
        // cc
        
        for (int i = 0; i < 32; i++) {
            if ((left >> i) == (right >> i)) {
                return (left >> i) << i;
            }
        }
        
        return 0;
    }
}

// time: O(1); space: O(1);
