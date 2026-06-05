class WordDictionary {
    static class Trie {
        Trie[] child = new Trie[26];
        boolean word;
    }

    Trie root = new Trie();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Trie trie = root;

        for (char c : word.toCharArray()) {
            if (trie.child[c - 'a'] == null) {
                trie.child[c - 'a'] = new Trie();
            }

            trie = trie.child[c - 'a'];
        }

        trie.word = true;
    }

    public boolean search(String word) {
        Trie trie = root;
        return search(word, 0, trie);
    }

    private boolean search(String word, int index, Trie trie) {
        if (index == word.length() && trie.word) {
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
            if (trie.child[c - 'a'] != null) {
                return search(word, index + 1, trie.child[c - 'a']);
            }
        }

        return false;
    }
}
