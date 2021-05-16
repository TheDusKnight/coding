package leetcode._0374_GuessNumberHigherorLower;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n <= 0) throw new RuntimeException("Wrong input");
        
        int left=0, right=n, mid;
        while (left+1 < right) {
            mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == -1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (guess(left) == 0) return left;
        if (guess(right) == 0) return right;
        // not found
        throw new RuntimeException("Result not Found");
    }
}
