class TimeMap {
    Map<String, List<Map.Entry<Integer, String>>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new ArrayList<>())
            .add(new AbstractMap.SimpleImmutableEntry<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        var timestamps = map.get(key);
        int lo = 0, hi = timestamps.size() - 1;
        var res = "";

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            var entry = timestamps.get(mid);

            if (entry.getKey() <= timestamp) {
                res = entry.getValue();
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}
