class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[n];  // initialized to 0

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]) {
                int index = deque.pollLast();
                output[index] = i - index;
            }

            deque.offerLast(i);
        }

        return output;
    }
}
