package leetcode._0443_StringCompression;

// slow fast pointer + recursion
class Solution {
    int slow;
    public int compress(char[] chars) {
        if (chars == null) throw new IllegalArgumentException();
        if (chars.length <= 1) return chars.length;
        
        int len = chars.length;
        
        slow = 0;
        int fast = 0;
        while (fast < len) {
            char c = chars[fast];
            int count = 0;
            while (fast == 0 || (fast < len && chars[fast] == c)) {
                count++;
                fast++;
            }
            
            chars[slow++] = c; // 1
            if (count > 1) {
                char tmp = (char)(recursion(chars, count) + '0');
                // 绝对不能先赋值，因为slow会变化
                chars[slow++] = tmp;
            }
        }
        
        return slow;
    }
    
    private int recursion(char[] chars, int count) {
        if (count < 10) return count;
        
        int curDigit = recursion(chars, count / 10);
        chars[slow++] = (char)(curDigit + '0');
        
        return count % 10;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] chars = new char[] {'a', 'b', 'b', 
        'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        
        System.out.println(sol.compress(chars));
    }
}

// time: O(N); space: O(N);

