class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] carfleet = new int[n][2];

        for (int i = 0; i < n; i++) {
            carfleet[i][0] = position[i];
            carfleet[i][1] = speed[i];
        }

        Arrays.sort(carfleet, (a, b) -> b[0] - a[0]);

        int count = 1;
        double prevTime = (double) (target - carfleet[0][0]) / carfleet[0][1];

        for (int i = 1; i < n; i++) {
            int p = carfleet[i][0];
            int s = carfleet[i][1];

            double time = (double) (target - p) / s;

            if (time > prevTime) {
                count++;
                prevTime = time;
            }
        }

        return count;
    }
}
