package leetcode._0204_CountPrimes;

import java.util.Arrays;

// Math: Sieve of Eratosthenes
class Solution2 {
    public int countPrimes(int n) {
        // cc
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        // for loop的作用不是为了标记谁是prime而是为了标记谁不是prime
        for (int i = 2; i * i < n; i++) { // 只需loop到sqrt(n)即可，因为sqrt(n)之后的数字一定被mark过了
            if (!isPrime[i]) continue;
            
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        
        return count;
    }
}

// time: O(sqrt(n)log(log(n))) 不需要掌握; space: O(n);