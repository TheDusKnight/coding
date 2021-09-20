package leetcode._0273_IntegerToEnglishWords;

// 自己写的无限循环

public class Solution2 {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(long num) {
        if (num < 0) return null;
        if (num == 0) return "Zero";

        String words = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper((int) (num % 1000)) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i = (i + 1) % THOUSANDS.length;
        }

        words = words.trim();
        return words;
    }

    // 进入helper的int都小于1000
    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        // long a = 123456789;
        // long b = 1000000;
        // long num = a * b;
        Solution2 sol = new Solution2();
        String res = sol.numberToWords((long)900);
        System.out.println(res);
    }
}

