class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int n = 9;
        
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] squares = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] == '.') {
                    continue;
                }

                int v = board[i][j] - '1';

                if ((rows[i] & (1 << v)) > 0 
                    || (cols[j] & (1 << v)) > 0 
                    || (squares[(i/3)*3 + j/3] & (1 << v)) > 0) {
                        return false;
                }

                rows[i] |= (1 << v);
                cols[j] |= (1 << v);
                squares[(i/3)*3 + j/3] |= (1 << v);
            }
        }

        return true;
    }
}
