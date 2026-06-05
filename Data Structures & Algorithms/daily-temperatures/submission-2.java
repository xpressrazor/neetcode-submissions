class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n-1; i >= 0; i--) {
            int j = i + 1;

            while (j < n && temperatures[i] >= temperatures[j]) {
                if (res[j] == 0) {
                    j = n;
                    break;
                }

                j += res[j];
            }

            if (j < n) {
                res[i] = j - i;
            }
        }

        return res;
    }
}
