package leetcode._1304_FindNUniqueIntegersSumUpToZero;

class Solution {
    public int[] sumZero(int n) {
        // cc
        if (n == 1) return new int[] {0};
        
        int[] res = new int[n];
        int pos = 1;
        int neg = -1;
        int counter = 0;
        
        for (int i = 0; i < n/2; i++) {
            res[counter++] = pos++;
            res[counter++] = neg--;
        }
            
        return res;
    }
}
