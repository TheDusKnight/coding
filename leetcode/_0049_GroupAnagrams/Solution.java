package leetcode._0049_GroupAnagrams;
import java.util.*;

// hashmap prime hash as key, string as value
// TODO: union find -> map reduce
class Solution {
    private static final int[] PRIMES = new int[] { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
        71, 73, 79, 83, 89, 97, 101, 107 };

public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    if (strs == null || strs.length <= 1) {
        res.add(Arrays.asList(strs));
        return res;
    }
    
    Map<Integer, List<String>> map = new HashMap<>();
    for (String str: strs) {
        int tmp = hash(str);
        if (!map.containsKey(tmp)) map.put(tmp, new ArrayList<>());
        map.get(tmp).add(str);
    }
    
    for (List<String> tmp: map.values()) {
        res.add(tmp);
    }
    
    return res;
}

private int hash(String s) {
    int hash = 1;
    for (int i = 0; i < s.length(); i++) {
        hash *= PRIMES[s.charAt(i) - 'a'];
    }
    return hash;
}
}
