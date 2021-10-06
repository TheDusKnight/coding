package leetcode._0243_ShortestWordDistance;

// two pointers
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict.length == 1) return 0;
        
        int idx1 = -1, idx2 = -1, n = wordsDict.length, minDis = n;
        for (int i = 0; i < n; i++) {
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
                if (idx2 != -1) {
                    minDis = Math.min(minDis, Math.abs(idx1 - idx2));
                }
            } else if (wordsDict[i].equals(word2)) {
                idx2 = i;
                if (idx1 != -1) {
                    minDis = Math.min(minDis, Math.abs(idx1 - idx2));
                }
            }
        }
        
        return minDis;
    }
}

// time: O(N*K) K is the longest word of word1 and word2; space: O(1);
