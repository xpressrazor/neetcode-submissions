class Solution {
    int m, n;
    int[] moves = {-1, 0, 1, 0, -1};

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                floodFill(board, i, 0);
            }

            if (board[i][n-1] == 'O') {
                floodFill(board, i, n-1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                floodFill(board, 0, i);
            }

            if (board[m-1][i] == 'O') {
                floodFill(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void floodFill(char[][] board, int i, int j) {
        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                floodFill(board, x, y);
            }
        }
    }
}
