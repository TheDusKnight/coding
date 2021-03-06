package leetcode._0037_SudokuSolver;

// dfs每次搞定一个点
class Solution {
    public void solveSudoku(char[][] board) {
        // cc
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.') continue;
                for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                    if(isValid(board, i, j, c)){
                        board[i][j] = c; //Put c for this cell

                        if(solve(board))
                            return true; //If it's the solution return true
                        else
                            board[i][j] = '.'; //Otherwise go back
                    }
                }
                // 比如有个cell没有valid num，那么最终 return false;
                return false;
            }
        }
        // 所有board点都填满，返回true
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}

// time: O(1) because board size is fixed; space: O(1);