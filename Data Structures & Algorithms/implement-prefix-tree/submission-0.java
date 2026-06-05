class PrefixTree {
    static class Trie {
        Trie[] child = new Trie[26];
        boolean isWord;
    }

    private Trie root;

    public PrefixTree() {
        root = new Trie();     
    }

    public void insert(String word) {
        Trie cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (cur.child[index] == null) {
                cur.child[index] = new Trie();
            }

            cur = cur.child[index];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (cur.child[index] == null) {
                return false;
            }

            cur = cur.child[index];
        }

        return cur.isWord == true;
    }

    public boolean startsWith(String prefix) {
        Trie cur = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (cur.child[index] == null) {
                return false;
            }

            cur = cur.child[index];
        }

        return cur != null;
    }
}
