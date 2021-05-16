package leetcode._0242_ValidAnagram;

// character frequency hash / prime hash
public class Solution4 {
    private static final int[] PRIMES = new int[] { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101, 107 };

    public boolean isAnagram(String s, String t) {
        return hash(s) == hash(t);
    }

    private long hash(String s) {
        long hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash *= PRIMES[s.charAt(i) - 'a'];
        }
        return hash;
    }
}

// frequency hash using length without prime
// a b c    1 * n^1 + 3*n^2 + 2*n^3     n=length
// 1 3 2
