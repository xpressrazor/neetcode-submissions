class Solution {
    static class Trie {
        Trie[] child = new Trie[26];
        String word;
    }

    Trie root = new Trie();

    private void addWords(String[] words) {

        for (String word : words) {
            Trie cur = root;

            for (char c : word.toCharArray()) {
                if (cur.child[c-'a'] == null) {
                    cur.child[c - 'a'] = new Trie();
                }

                cur = cur.child[c - 'a'];
            }

            cur.word = word;
        }
    }

    int m, n;
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        addWords(words);

        m = board.length;
        n = board[0].length;

        Trie trie = root;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = board[i][j] - 'a';

                if (trie.child[index] != null) {
                    dfs(board, i, j, trie);
                }
            }
        }

        return result;
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private void dfs(char[][] board, int i, int j, Trie trie) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') {
            return;
        }

        char c = board[i][j];
        int index = c - 'a';

        if (trie.child[index] == null) {
            return;
        }

        // let's move to child as we started with root
        trie = trie.child[index];

        if (trie.word != null) {
            result.add(trie.word);
            trie.word = null;
        }

        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k + 1];

            dfs(board, x, y, trie);
        }

        board[i][j] = c;
    }
}
