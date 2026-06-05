class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] output = new int[n];

        for (int i = n-1; i >= 0; i--) {
            int j = i + 1;

            while (j < n && temperatures[i] >= temperatures[j]) {
                if (output[j] == 0) {
                    j = n;
                    break;
                }

                j += output[j];
            }

            if (j < n) {
                output[i] = j - i;
            }
        }

        return output;
    }
}
