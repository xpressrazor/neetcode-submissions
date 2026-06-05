class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0, j = n-1;
        int tank = gas[n-1] - cost[n-1];

        while (i < j) {
            if (tank > 0) {
                tank += gas[i] - cost[i];
                i++;
            } else {
                j--;
                tank += gas[j] - cost[j];
            }
        }

        return tank >= 0 ? i : -1;
    }
}
