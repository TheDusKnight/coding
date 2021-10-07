package leetcode._0605_CanPlaceFlowers;

// greedy能种则种
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) { // ele is 1, check valid
                if (i-1 >= 0 && flowerbed[i-1] == 1) {
                    // 如果invalid说明填错了，拔掉重填
                    flowerbed[i-1] = 0;
                    n++;
                }
            }
            
            if (n == 0) return true; // n--之后还要在check后面的ele是否为1，check完如果n等于0直接return true；
            
            if (flowerbed[i] == 0) { // ele is 0, check if can place
                if (i == 0 || (i-1 >= 0 && flowerbed[i-1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        
        // 走完后check n是否用完
        return n == 0;
    }
}

// time: O(N); space: O(1);
