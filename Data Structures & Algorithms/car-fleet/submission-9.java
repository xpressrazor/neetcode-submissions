class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] fleet = new int[n][2];

        for (int i = 0; i < n; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        Arrays.sort(fleet, (a, b) -> b[0] - a[0]);

        int index = -1;
        double[] stack = new double[n];

        for (int i = 0; i < n; i++) {
            double time = (target - fleet[i][0]) / (double) fleet[i][1];

            if (index != -1 && time <= stack[index]) {
                continue;
            } else {
                stack[++index] = time;
            }
        }

        return index + 1;
    }
}
