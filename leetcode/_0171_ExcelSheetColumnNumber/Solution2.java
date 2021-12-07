package leetcode._0171_ExcelSheetColumnNumber;

// scan from left to right
class Solution2 {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) throw new IllegalArgumentException();
        
        int len = columnTitle.length(), sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum * 26 + (columnTitle.charAt(i)-'A'+1);
        }
        
        return sum;
    }
}

// time: O(N); space: O(1);
