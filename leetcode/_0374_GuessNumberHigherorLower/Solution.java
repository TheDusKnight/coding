package leetcode._0374_GuessNumberHigherorLower;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

abstract class GuessGame {
    public int guess(int input) {
        return 1;
    }
}

// binary search左右越过
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lower = 1, upper = n;
        int mid = 0;
        
        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res == 1) lower = mid+1;
            else upper = mid-1;
        }
        
        return -1;
    }
}