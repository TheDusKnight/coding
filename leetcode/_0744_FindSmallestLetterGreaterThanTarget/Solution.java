package leetcode._0744_FindSmallestLetterGreaterThanTarget;

// Linear scan
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // cc
        
        for (char c: letters) {
            if (c > target) return c;
        }
        return letters[0];
    }
}

// time: O(N); space: O(1);
