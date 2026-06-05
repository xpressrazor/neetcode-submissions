class PrefixTree {
    static class Trie {
        Trie[] child = new Trie[26];
        boolean isWord;
    }

    public PrefixTree() {
         
    }

    Trie root = new Trie();

    public void insert(String word) {
        Trie trie = root;

        for (char c : word.toCharArray()) {
            if (trie.child[c - 'a'] == null) {
                trie.child[c - 'a'] = new Trie();
            }

            trie = trie.child[c - 'a'];
        }

        trie.isWord = true;
    }

    public boolean search(String word) {
        Trie trie = root;

        for (char c : word.toCharArray()) {
            if (trie.child[c - 'a'] == null) {
                return false;
            }

            trie = trie.child[c - 'a'];
        }

        return trie.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie trie = root;
        
        for (char c : prefix.toCharArray()) {
            if (trie.child[c - 'a'] == null) {
                return false;
            }

            trie = trie.child[c - 'a'];
        }

        return trie != null;
    }
}
