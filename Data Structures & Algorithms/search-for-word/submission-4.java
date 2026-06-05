class Solution {
    private int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int[] moves = {-1, 0, 1, 0, -1};

    private boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k + 1];

            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == word.charAt(index) 
                && search(board, word, x, y, index + 1)) {
                return true;
            }
        }

        board[i][j] = word.charAt(index - 1);
        return false;
    }
}
