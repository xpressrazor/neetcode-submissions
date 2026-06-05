class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] fleet = new int[n][2];

        for (int i = 0; i < n; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        Arrays.sort(fleet, (a, b) -> Integer.compare(b[0], a[0]));

        double prevTime = (double)(target - fleet[0][0]) / fleet[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            double time = (double) (target - fleet[i][0]) / fleet[i][1];

            if (time > prevTime) {
                count++;
                prevTime = time;
            }
        }

        return count;
    }
}
