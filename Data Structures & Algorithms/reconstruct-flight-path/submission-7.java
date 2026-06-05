class Solution {
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graphMap = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graphMap.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs(graphMap, "JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> graphMap, String src) {
        PriorityQueue<String> pq = graphMap.get(src);

        while (pq != null && !pq.isEmpty()) {
            dfs(graphMap, pq.poll());
        }

        result.add(src);
    }
}
