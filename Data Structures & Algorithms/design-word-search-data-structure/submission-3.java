class WordDictionary {
    static class Trie {
        Trie[] child = new Trie[26];
        boolean isWord = false;
    }

    private Trie root;

    public WordDictionary() {
        root = new Trie();  
    }


    public void addWord(String word) {
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
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Trie trie) {
        if (index == word.length() && trie.isWord) {
            return true;
        } else if (index >= word.length()) {
            return false;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (trie.child[i] != null && search(word, index + 1, trie.child[i])) {
                    return true;
                }
            }
        } else {
            return trie.child[c - 'a'] != null && search(word, index + 1, trie.child[c - 'a']);
        }

        return false;
    }
}
