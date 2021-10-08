package OA.amazon.CalaculateValueX;

import org.junit.jupiter.api.Test;

// Amazon OA
public class Solution {

    @Test
    public void test() {
        System.out.println(lock(9, 97));
    }

    public long subSeq(long no, char pChar) {
        String s = String.valueOf(no);
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pChar == s.charAt(i))
                continue;
            pChar = s.charAt(i);
            long n = s.charAt(i) - '0';
            res += n * Math.pow(10, s.length() - i - 1);
        }
        return res;
    }

    public long lock(long no1, long no2) {
        long res = subSeq(no1, '0');
        long prev = res;
        while (no1 < no2) {
            long base = increment(no1);
            no1++;
            char pChar = (char) ((no1 % (base * 10)) / base + '0');
            prev = (prev / base) * base + subSeq(no1 % base, pChar);
            res += prev;
        }
        return res;
    }

    public long increment(long no) {
        long base = 10;
        long rem = 9;
        while (no % base == rem) {
            rem += base * 9;
            base = base * 10;
        }
        return base;
    }
}
