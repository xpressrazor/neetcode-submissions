class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // merge position and speed to single array
        // sort by end position first
        // for each position, calculate the difference of 
        // (target - position) / speed to get minutes needed to reach target
        // add to stack
        // if a minute to target of last is smaller or equal to previous top of stack, remove current from stack
        // return size of stack
        // this way all overlapping speed are merged (as a later car can only follow and not overtake)

        int n = position.length;
        int[][] carfleet = new int[n][2];

        for (int i = 0; i < n; i++) {
            carfleet[i][0] = position[i];
            carfleet[i][1] = speed[i];
        }

        Arrays.sort(carfleet, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int p = carfleet[i][0];
            int s = carfleet[i][1];
            double timeToTarget = (double) (target - p) / s;
            stack.push(timeToTarget);

            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();

    }
}
