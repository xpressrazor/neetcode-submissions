class Solution {
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return result;
        }

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK", map);

        //Collections.reverse(result);
        return result;
    }

    private void dfs(String src, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> queue = map.get(src);

        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll(), map);
        }

        result.addFirst(src);
    }
}
