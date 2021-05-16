package leetcode._0009_PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        // if(x < 0 || (x % 10 == 0 && x != 0)) {
        //     return false;
        // }
        
        int reverseInt = 0;
        while (x > reverseInt) {
            reverseInt = reverseInt * 10 + x % 10;
            x /= 10;
        }
        
        // odd or even
        return x == reverseInt || x == reverseInt / 10;
    }
}

// time: O(log10(n))
// space: O(1)
