class Solution {

    static final int INF = Integer.MAX_VALUE / 4;

    static class SegmentTree {
        int[] tree, lazy;
        int n;

        public SegmentTree(int N) {
            this.n = N;
            tree = new int[4 * N];
            lazy = new int[4 * N];

            Arrays.fill(tree, INF);
            Arrays.fill(lazy, INF);
        }

        public int query(int index) {
            return query(0, 0, n-1, index);
        }

        public void update(int updateStart, int updateEnd, int val) {
            update(0, 0, n-1, updateStart, updateEnd, val);
        }

        private void propagate(int treeIndex, int arrStart, int arrEnd) {
            if (lazy[treeIndex] != INF) {
                tree[treeIndex] = Math.min(tree[treeIndex], lazy[treeIndex]);

                if (arrStart != arrEnd) {
                    lazy[2 * treeIndex + 1] = Math.min(lazy[2 * treeIndex + 1], lazy[treeIndex]);
                    lazy[2 * treeIndex + 2] = Math.min(lazy[2 * treeIndex + 2], lazy[treeIndex]);
                }

                lazy[treeIndex] = INF;
            }
        }

        private int query(int treeIndex, int arrStart, int arrEnd, int index) {
            propagate(treeIndex, arrStart, arrEnd);

            if (arrStart > arrEnd) {
                return INF;
            }

            if (arrStart == arrEnd) {
                return tree[treeIndex];
            }

            int mid = arrStart + ((arrEnd - arrStart) >> 1);

            if (index <= mid) {
                return query(2 * treeIndex + 1, arrStart, mid, index);
            } else {
                return query(2 * treeIndex + 2, mid + 1, arrEnd, index);
            }
        }

        private void update(int treeIndex, int arrStart, int arrEnd, int updateStart, int updateEnd, int val) {
            propagate(treeIndex, arrStart, arrEnd);

            if (arrStart > arrEnd || arrStart > updateEnd || updateStart > arrEnd) {
                return;
            }

            if (updateStart <= arrStart && arrEnd <= updateEnd) {
                lazy[treeIndex] = Math.min(lazy[treeIndex], val);
                return;
            }

            int mid = arrStart + ((arrEnd - arrStart) >> 1);

            update(2 * treeIndex + 1, arrStart, mid, updateStart, updateEnd, val);
            update(2 * treeIndex + 2, mid + 1, arrEnd, updateStart, updateEnd, val);
            tree[treeIndex] = Math.min(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        /*
            SegmentTree
            -----------
            O(n + m) log(k), O(k), k is extra space for unique points

            1. Get all points to a list
            2. Get unique points and sort it, and create order index map
            3. For each interval update segment tree with compress range and interval length (this sets the minimum value for each range)
                E.g. If range is 1, 6 and value 8, 1 to 6 will have 8, but if 4, 8 is 2, 4, to 6 will have 2 etc.
            4. Get range value for each query (as the value in update is always range value (length))
        */

        List<Integer> list = new ArrayList<>();
        
        for (int[] interval : intervals) {
            list.add(interval[0]);
            list.add(interval[1]);
        }

        for (int q : queries) {
            list.add(q);
        }

        List<Integer> sortedList = new ArrayList<>(new HashSet<>(list));
        Collections.sort(sortedList);

        Map<Integer, Integer> orderMap = new HashMap<>();
        int n = sortedList.size();

        for (int i = 0; i < n; i++) {
            orderMap.put(sortedList.get(i), i);
        }

        SegmentTree segmentTree = new SegmentTree(sortedList.size());

        for (int[] interval : intervals) {
            segmentTree.update(orderMap.get(interval[0]), orderMap.get(interval[1]), interval[1] - interval[0] + 1);
        }

        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int val = segmentTree.query(orderMap.get(queries[i]));
            result[i] = val == INF ? -1 : val;
        }

        return result;
    }
}
