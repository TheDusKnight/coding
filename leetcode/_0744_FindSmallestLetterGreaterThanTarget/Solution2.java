package leetcode._0744_FindSmallestLetterGreaterThanTarget;

// binary search
class Solution2 {
    public char nextGreatestLetter(char[] letters, char target) {
        // cc
        
        int left = 0, right = letters.length, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return letters[right % letters.length];
    }
}

// time: O(log(N)); space: O(1);
