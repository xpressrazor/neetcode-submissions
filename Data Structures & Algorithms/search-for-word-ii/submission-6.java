class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            boolean flag = false;

            for (int i = 0; i < m && !flag; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == word.charAt(0)) {
                        if (search(board, i, j, word, 0)) {
                            result.add(word);
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private boolean search(char[][]board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) return false;

        char c = board[i][j];
        board[i][j] = '#';
        boolean ret = false;

        for (int d = 0; d < 4; ++d) {
            int x = i + moves[d], y = j + moves[d+1];

            if (search(board, x, y, word, index + 1)) {
                ret = true;
            }
        }

        board[i][j] = c;
        return ret;
    }
}