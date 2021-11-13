package mianjing.google._1525_NumberOfGoodWaysToSplitAString;

// google oa
// prefix calc
class Solution {
    public int numSplits(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        int count = 0;
        int len = s.length();
        int[] left = new int[len];
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < len; i++) {
            set.add(s.charAt(i));
            left[i] = set.size();
        }
        set.clear();
        for (int i = len-1; i >= 1; i--) {
            set.add(s.charAt(i));
            if (left[i-1] == set.size()) count++;
        }
        
        return count;
    }
}

// time: O(N); space: O(N);
