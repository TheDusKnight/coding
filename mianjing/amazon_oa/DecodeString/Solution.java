package mianjing.amazon_oa.DecodeString;

// array two loop
class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][] { new char[] { 'm', 'n', 'e', 's', 'i', '_', '_' },
                new char[] { '_', 'y', 'a', '_', '_', 'k', '_' }, new char[] { '_', '_', '_', 'm', 'i', 'm', 'e' } };
        String origString = decodeString(matrix);
        System.out.println(origString);
    }

    public static String decodeString(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = 0;
        while (j < col) {
            int start = j; // start每次从j的位置开始直到col尾部
            while (i < row && start < col) {
                sb.append(matrix[i][start] != '_' ? matrix[i][start] : ' ');
                i++;
                start++;
            }
            i = 0; // set row idx back to 0
            j++; // 根据题意，j每次内部循环加一
        }
        return sb.toString().trim();
    }
}
