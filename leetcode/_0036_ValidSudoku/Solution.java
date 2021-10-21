package leetcode._0036_ValidSudoku;
import java.util.*;

// hashset
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // cc
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!set.add(number + "in row " + i) ||
                        !set.add(number + "in col " + j) ||
                         !set.add(number + "in block " + i/3 + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}

// time: O(1)