package leetcode._0334_IncrasingTripletSubsequence;

// Greedy
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // cc
        
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        
        for (int num: nums) {
            if (num > second) {
                return true;
            } else if (num <= first) {
                first = num;
            } else {
                second = num; // second <= num > first
            }
        }
        
        return false;
    }
}

// time: O(N); space: O(1)
