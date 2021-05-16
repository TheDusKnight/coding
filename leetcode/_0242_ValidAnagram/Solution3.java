package leetcode._0242_ValidAnagram;

// count sort
public class Solution3 {
    public boolean isAnagram(String s, String t) {
        if ((s == null || t == null) || (s.length() != t.length())) return false;

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        
        // all possible取值可能性有限。index对应字母，value对应个数，和strStr不一样
        int[] countSort = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            countSort[sCharArray[i] - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            countSort[tCharArray[i] - 'a']--;
            if (countSort[tCharArray[i] - 'a'] < 0) return false;
        }
        return true;
    }
}
