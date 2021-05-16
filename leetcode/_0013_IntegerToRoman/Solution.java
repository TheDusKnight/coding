package leetcode._0013_IntegerToRoman;

class Solution {
    public int romanToInt(String s) {
        // cc
        
        int[] vals = new int[s.length()];
        for (int i = 0; i < vals.length; i++) {
            char c = s.charAt(i);
            
            switch(c) {
                case 'M' : vals[i] = 1000;
                break;
                case 'D' : vals[i] = 500;
                break;
                case 'C' : vals[i] = 100;
                break;
                case 'L' : vals[i] = 50;
                break;
                case 'X' : vals[i] = 10;
                break;
                case 'V' : vals[i] = 5;
                break;
                case 'I' : vals[i] = 1;
                break;
            }
        }
        
        int res = 0;
        for (int i = 0; i < vals.length; i++) {
            if (i == vals.length - 1) {
                res += vals[i];
            } else if (vals[i] < vals[i+1]) {
                res -= vals[i];
            } else {
                res += vals[i];
            }
        }
        return res;
    }
}