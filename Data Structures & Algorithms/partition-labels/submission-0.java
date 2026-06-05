class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            lastIndexMap.put(s.charAt(i), i);  // override with last index
        }

        List<Integer> result = new ArrayList<>();

        int size = 0, maxIndex = 0;

        for (int i = 0; i < n; i++) {
            size++;
            maxIndex = Math.max(maxIndex, lastIndexMap.get(s.charAt(i)));

            // if current character reaches it's last index, we can use the size and
            // reset it for next partition as well
            if (maxIndex == i) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}
