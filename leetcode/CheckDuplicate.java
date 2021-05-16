package leetcode;

// input is sorted or adjacent
public class CheckDuplicate {
    public String removeSpace(String s, int k) {
        if (s == null || s.length() <= k) {
            return s;
        }
        char[] array = s.toCharArray();
        int slow = k;

        for (int fast = k; fast < s.length(); fast++) {
            // 不相等要留
            // 一样的跳过，slow不动，等不相等时再覆盖
            if (array[fast] != array[slow - k]) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }
}
