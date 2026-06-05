class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] visited = new boolean[n+1];
        return dfs(s, wordDict, 0, visited);
    }

    private boolean dfs(String s, List<String> wordDict, int index, boolean[] visited) {
        if (index == s.length()) {
            return true;
        }

        if (visited[index]) {
            return false;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, index) && dfs(s, wordDict, index + word.length(), visited)) {
                return true;
            }
        }

        visited[index] = true;
        return false;
    }
}
