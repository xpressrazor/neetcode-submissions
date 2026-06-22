class TrieNode {
    TrieNode[] child = new TrieNode[26];
    String word;
}

class Solution {
    TrieNode root = new TrieNode();
    private void insert(String[] words) {
        for (String word : words) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.child[index] == null) cur.child[index] = new TrieNode();
                cur = cur.child[index];
            }

            cur.word = word;
        }
    }

    private List<String> resultList = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        insert(words);

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = board[i][j] - 'a';

                if (root.child[index] != null) {
                    search(board, i, j, root.child[index]);
                }
            }
        }

        return resultList;
    }

    private int[] moves = {-1, 0, 1, 0, -1};

    private void search(char[][] board, int i, int j, TrieNode cur) {
        if (cur.word != null) {
            resultList.add(cur.word);
            cur.word = null;
        }

        char c = board[i][j];
        board[i][j] = '#';

        for (int d = 0; d < 4; ++d) {
            int x = i + moves[d];
            int y = j + moves[d+1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
                char c1 = board[x][y];
                int ind = c1 - 'a';
                if (cur.child[ind] != null) {
                    search(board, x, y, cur.child[ind]);
                }
            }
        }

        board[i][j] = c;
    }
}
