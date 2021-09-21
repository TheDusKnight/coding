package leetcode._0165_CompareVersionNumbers;

// 非高频，Split + Parse, Two Pass. 有one pass solution但是太难了
class Solution {
    public int compareVersion(String version1, String version2) {
      String[] nums1 = version1.split("\\.");
      String[] nums2 = version2.split("\\.");
      int n1 = nums1.length, n2 = nums2.length;
  
      // compare versions
      int i1, i2;
      for (int i = 0; i < Math.max(n1, n2); ++i) {
        // 如果当前idx小于长度，将string解析成int，否则无脑填0
        i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
        i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
        if (i1 != i2) {
          return i1 > i2 ? 1 : -1;
        }
      }
      // the versions are equal
      return 0;
    }
  }
// time: O(M + N); space: O(M + N);