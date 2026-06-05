class TimeMap {

    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        var timestamps = map.get(key);
        var entry = timestamps.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}
