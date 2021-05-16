package leetcode._0139_WordBreak;
import java.util.*;

// list of index 只保留历史上index是true的情况
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // cc

        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }

        int len = s.length();
        List<Integer> list = new LinkedList<>(); // Or ArrayList
        list.add(0);

        // first i letters [0, i)
        for (int i = 1; i <= len; i++) {
            // 左边看dp有没有，右边看是否dict contains
            for (int j: list) {
                if (set.contains(s.substring(j, i))) {
                    list.add(i);
                    break;
                }
            }
        }
        return list.contains(s.length());
    }
}
