package leetcode._0171_ExcelSheetColumnNumber;

// scan from right to left
class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) throw new IllegalArgumentException();
        
        // Map<Character, Integer> map = new HashMap<>();
        // for (int i = 1; i <= 26; i++) {
        //     map.put((char)('A'+i-1), i);
        // }
        
        int len = columnTitle.length(), sum = 0;
        for (int i = len-1; i >= 0; i--) {
            // sum += map.get(columnTitle.charAt(i))*Math.pow(26, len-1-i);
            sum += (columnTitle.charAt(i)-'A'+1)*Math.pow(26, len-1-i);
        }
        
        return sum;
    }
}

// time: O(N); space: O(1);
