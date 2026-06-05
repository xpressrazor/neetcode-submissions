class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] traveling = new int[n][2];
        for (int i = 0; i < n; i++) {
            traveling[i][0] = position[i];
            traveling[i][1] = speed[i];
        }

        Arrays.sort(traveling, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            double distance = target - traveling[i][0];
            double time = distance / traveling[i][1];

            stack.push(time);

            if (stack.size() >= 2 && time <= stack.get(stack.size() - 2)) {
                stack.pop();
            }

        }

        return stack.size();
    }
}
