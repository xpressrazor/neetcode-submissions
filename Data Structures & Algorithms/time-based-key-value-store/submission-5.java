class TimeMap {

    Map<String, List<Map.Entry<Integer, String>>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new ArrayList<>())
            .add(new AbstractMap.SimpleEntry<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        var timestamps = map.get(key);
        String res = "";

        if (timestamps == null) {
            return "";
        }

        int lo = 0, hi = timestamps.size() - 1;

        while (lo <= hi) {
            var mid = lo + ((hi - lo) >> 1);

            if (timestamps.get(mid).getKey() <= timestamp) {
                res = timestamps.get(mid).getValue();
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}
