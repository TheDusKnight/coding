package mianjing.google_oa.RingsOnRods;

public class Solution {
    public int getRodScores(String s) {
        if (s == null || s.length() < 6) return 0;

        int score = 0, len = s.length();
        int[] rods = new int[10];

        for (int i = 1; i < len; i+=2) {
            int rod = s.charAt(i) - '0';
            char ring = s.charAt(i-1);
            int rodScore = rods[rod];
            if (ring == 'B' && rodScore != 1 && rodScore != 3 && rodScore != 5 && rodScore != 7) {
                rods[rod] += 1;
            } else if (ring == 'R' && rodScore != 2 && rodScore != 3 && rodScore != 6 && rodScore != 7) {
                rods[rod] += 2;
            } else if (ring == 'G' && rodScore != 4 && rodScore != 6 && rodScore != 7) {
                rods[rod] += 4;
            }
        }

        for (int rod: rods)
            if (rod == 7) score++;

        return score;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // String s = "B2R5G2R2";
        // String s = "B2R5G2R2B5G2G5";
        // String s = "B2R5G2R2";
        String s = "R8R0B5G1B8G8";
        System.out.println(sol.getRodScores(s));
    }
}
