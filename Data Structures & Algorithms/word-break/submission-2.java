class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        return dfs(s, 0, wordDict, visited);
    }

    private boolean dfs(String s, int index, List<String> wordDict, boolean[] visited) {
        if (index == s.length()) {
            return true;
        } else if (visited[index]) {
            return false;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, index) && dfs(s, index + word.length(), wordDict, visited)) {
                return true;
            }
        }

        visited[index] = true;
        return false;
    }
}
