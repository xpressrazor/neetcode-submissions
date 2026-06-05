class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            if (!graph.containsKey(cur) || graph.get(cur).isEmpty()) {
                result.add(stack.pop());
            } else {
                stack.push(graph.get(cur).poll());
            }
        }

        Collections.reverse(result);
        return result;
    }
}
