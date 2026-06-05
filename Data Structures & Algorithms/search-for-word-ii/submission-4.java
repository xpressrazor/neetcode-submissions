class Solution {
    private static class Trie {
        Trie[] child = new Trie[26];
        String word;
    }

    private void addWords(String[] words, Trie root) {
        for (String word : words) {
            Trie trie = root;

            for (char c : word.toCharArray()) {
                
                if (trie.child[c - 'a'] == null) {
                    trie.child[c - 'a'] = new Trie();
                }

                trie = trie.child[c - 'a'];
            }

            trie.word = word;
        }
    }
    
    private int m, n;
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        Trie root = new Trie();
        addWords(words, root);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = board[i][j] - 'a';

                if (root.child[index] != null) {
                    search(board, i, j, root);
                }
            }
        }

        return result;
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private void search(char[][] board, int i, int j, Trie trie) {
        if (trie == null || board[i][j] == '#') {
            return;
        } 
        
        char c = board[i][j];
        if (board[i][j] == '#' || trie.child[c - 'a'] == null) {
            return;
        }

        trie = trie.child[c - 'a'];

        if (trie.word != null) {
            result.add(trie.word);
            trie.word = null;
        }

        
        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '#') {
                search(board, x, y, trie);
            }
        }

        board[i][j] = c;
    }
}
