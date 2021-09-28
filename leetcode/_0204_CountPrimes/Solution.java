package leetcode._0204_CountPrimes;

// brute force check every number less than target is prime or not
// https://leetcode-cn.com/problems/count-primes/solution/kuai-lai-miao-dong-shai-zhi-shu-by-sweetiee/
class Solution {
    public int countPrimes(int n) {
        // cc
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        
        return count;
    }
    
    // private boolean isPrime(int i) {
    //     for (int j = 2; j < i; j++) {
    //         if (i % j == 0) return false;
    //     }
        
    //     return true;
    // }

    // 改进，只需要加到sqrt(i)即可
    private boolean isPrime(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) return false;
        }
        
        return true;
    }
}

// time: O(n); space: O(1)
