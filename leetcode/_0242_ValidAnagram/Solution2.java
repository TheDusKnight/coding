package leetcode._0242_ValidAnagram;
import java.util.*;

// Sort
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if ((s == null || t == null) || (s.length() != t.length())) return false;

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        // 不能用 array1.equals(array2)因为没有改写compare method
        return Arrays.equals(sCharArray, tCharArray);
    }
}
// time: O(n*log(n))