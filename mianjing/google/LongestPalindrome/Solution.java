package mianjing.google.LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

// A string is a palindrome if it reads the same backward as forwards.
//  For example, "madam" and "racecar" are palindromes, but "milk" is not.

// We are given an array of N strings in which each string consist
//  of two lowercase English letters. We would like to join as many strings 
// together as possible in order to obtain a palindrome.
public class Solution {
    public int getLongestPalidnrome(String[] arr) {
        // cc

        int count = 0;
        Set<String> set = new HashSet<>();
        for (String s: arr) {
            String s_inverse = new StringBuilder(s).reverse().toString();
            if (!set.contains(s_inverse)) set.add(s);
            else {
                count += 4;
                set.remove(s_inverse);
            }
        }

        if (!set.isEmpty()) {
            for (String s: set) {
                String s_inverse = new StringBuilder(s).reverse().toString();
                if (s.equals(s_inverse)) {
                    count += 2;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = {"ck", "kc", "ho", "kc"};
        String[] arr1 = {"oo", "oo", "oo"};
        String[] arr2 = {"oo", "oo", "oo", "oo"};
        String[] arr3 = {"oo", "oo", "oo", "oo", "oo"};
        String[] arr4 = {"oo", "oo", "oo", "ss"};
        String[] arr5 = {"oo", "oo", "oo", "ss","ss","ss"};
        System.out.println(sol.getLongestPalidnrome(arr5));
    }
}
