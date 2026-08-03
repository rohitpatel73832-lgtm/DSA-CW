// class Solution {
//     private boolean solve(char[][] board) {

//         for (int r = 0; r < 9; r++) {
//             for (int c = 0; c < 9; c++) {

//                 if (board[r][c] == '.') {

//                     for (char digit = '1'; digit <= '9'; digit++) {

//                         if (isSafe(board, r, c, digit)) {
//                             board[r][c] = digit;

//                             if (solve(board)) return true; // recurse

//                             board[r][c] = '.'; // backtrack
//                         }
//                     }

//                     return false; // no digit fits → backtrack
//                 }
//             }
//         }

//         return true; // solved!
//     }

//     private boolean isSafe(char[][] board, int r, int c, char ch) {
//         // Check row
//         for (int col = 0; col < 9; col++) {
//             if (board[r][col] == ch) return false;
//         }

//         // Check col
//         for (int row = 0; row < 9; row++) {
//             if (board[row][c] == ch) return false;
//         }

//         // Check 3x3 box
//         int boxRow = (r / 3) * 3;
//         int boxCol = (c / 3) * 3;

//         for (int i = boxRow; i < boxRow + 3; i++) {
//             for (int j = boxCol; j < boxCol + 3; j++) {
//                 if (board[i][j] == ch) return false;
//             }
//         }

//         return true;
//     }
//     public boolean isValidSudoku(char[][] board) {
//         int n=9;
//         HashSet<Character>[] rows=new HashSet[n];
//         HashSet<Character>[] cols=new HashSet[n];
//         HashSet<Character>[] boxes=new HashSet[n];

//         for(int i=0; i<n;i++){
//             rows[i]=new HashSet<Character>();
//             cols[i]=new HashSet<Character>();
//             boxes[i]=new HashSet<Character>();
//         }

//         for(int r=0; r<board.length;r++){
//             for(int c=0;c<board[0].length;c++){
//                 char cell=board[r][c];

//                 if(cell=='.'){
//                     continue;
//                 }
//                 if(rows[r].contains(cell)){
//                     return false;
//                 }
//                 rows[r].add(cell);

//                 if(cols[c].contains(cell)){
//                     return false;
//                 }
//                 cols[c].add(cell);

//                 int boxIndex=3*(r/3)+(c/3);
//                 if(boxes[boxIndex].contains(cell)){
//                     return false;
//                 }
//                 boxes[boxIndex].add(cell);


//             }
//         }

//         return true;
//     }
//     public void solveSudoku(char[][] board) {
//         solve(board);
//     }
// }
class Solution {

    public boolean isValid(int row, int col, char num, char[][] board) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3×3 box
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean solve(int row, int col, char[][] board, char[][] grid) {

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = board[i][j];
                }
            }
            return true;
        }

        if (board[row][col] != '.') {

            if (col != 8)
                return solve(row, col + 1, board, grid);
            else
                return solve(row + 1, 0, board, grid);

        } else {

            for (char ch = '1'; ch <= '9'; ch++) {

                if (isValid(row, col, ch, board)) {

                    board[row][col] = ch;

                    boolean ans;
                    if (col != 8)
                        ans = solve(row, col + 1, board, grid);
                    else
                        ans = solve(row + 1, 0, board, grid);

                    if (ans) return true;

                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {

        char[][] grid = new char[9][9];

        solve(0, 0, board, grid);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = grid[i][j];
            }
        }
    }
}