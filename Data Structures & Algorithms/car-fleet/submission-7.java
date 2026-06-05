class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] fleet = new int[n][2];

        for (int i = 0; i < n; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        Arrays.sort(fleet, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int p = fleet[i][0];
            int s = fleet[i][1];

            double time = (double) (target - p) / s;

            stack.push(time);

            while (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}
