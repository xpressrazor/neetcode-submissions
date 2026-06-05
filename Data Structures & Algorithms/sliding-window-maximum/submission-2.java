class Solution {
    int[] tree;
    int n;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        n = N;

        while (Integer.bitCount(n) != 1) {
            n++;
        }

        build(nums, N);

        int[] output = new int[N + 1 - k];
        for (int i = 0; i < N + 1 - k; i++) {
            output[i] = query(i, i + k - 1);
        }

        return output;
    }

    private void build(int[] nums, int N) {
        tree = new int [n * 2];
        Arrays.fill(tree, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            tree[n+i] = nums[i];
        }

        for (int i = n-1; i > 0; i--) {
            tree[i] = Math.max(tree[i<<1], tree[i<<1|1]);
        }
    }

    private int query(int l, int r) {
        int max = Integer.MIN_VALUE;

        for (l += n, r += n+1; l < r; l >>= 1, r >>= 1) {
            if ((l&1) == 1) {
                max = Math.max(max, tree[l++]);
            }

            if ((r&1) == 1) {
                max = Math.max(max, tree[--r]);
            }
        }

        return max;
    }
}
