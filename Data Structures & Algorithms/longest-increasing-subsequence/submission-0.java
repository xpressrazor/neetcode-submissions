class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = binarySearch(list, num);

            if (index >= list.size()) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }

        return list.size();
    }

    int binarySearch(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int val = list.get(mid);

            if (val == target) {
                return mid;
            } else if (val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
