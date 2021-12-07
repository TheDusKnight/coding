package leetcode._0168_ExcelSheetColumnTitle;

// 26进制转换
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        
        return sb.reverse().toString(); // 小技巧：使用reverse
    }
}

// time: O(N); space: O(1);
