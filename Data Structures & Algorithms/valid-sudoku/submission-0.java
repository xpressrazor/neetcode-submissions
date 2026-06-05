class Solution {
    public boolean isValidSudoku(char[][] board) {
        return rowsValid(board) && colsValid(board) && blockValid(board);
    }

    private boolean rowsValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9' && !isValid(board[i][j] - '0', visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean colsValid(char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            boolean[] visited = new boolean[10];

            for (int i = 0; i < board.length; i++) {
                if (board[i][j] >= '1' && board[i][j] <= '9' && !isValid(board[i][j] - '0', visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean blockValid(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int idash = i * 3;
                int jdash = j * 3;

                boolean[] visited = new boolean[10];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[idash + k][jdash + l] >= '1' && board[idash + k][jdash + l] <= '9' && !isValid(board[idash + k][jdash + l] - '0', visited)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean isValid(int index, boolean[] visited) {
        if (visited[index]) {
            return false;
        }

        visited[index] = true;
        return true;
    }
}
