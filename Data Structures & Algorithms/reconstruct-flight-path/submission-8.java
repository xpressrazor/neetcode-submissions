class Solution {
    LinkedList<String> resultList = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs(graph, "JFK");
        return resultList;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String src) {
        PriorityQueue<String> queue = graph.get(src);

        while (queue!= null && !queue.isEmpty()) {
            dfs(graph, queue.poll());
        }

        resultList.addFirst(src);
    }
}
