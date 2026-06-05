class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int v = board[i][j] - '1';

                if ((rows[i] & (1 << v)) > 0 
                    || (cols[j] & (1 << v)) > 0 
                    || (squares[(i / 3) * 3 + j / 3] & (1 << v)) > 0) {
                    return false;
                }

                rows[i] |= (1 << v);
                cols[j] |= (1 << v);
                squares[(i / 3)*3 + j/3] |= (1 << v);
            }
        }

        return true;
    }
}
