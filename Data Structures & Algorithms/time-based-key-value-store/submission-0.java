class TimeMap {
 private class DataNode {
        String value;
        int timestamp;

        DataNode(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
 }
 private Map<String, List<DataNode>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new DataNode(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<DataNode> history = map.get(key);
        return binarySearch(history, timestamp);
    }
    private String binarySearch(List<DataNode> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).timestamp <= timestamp) {
                // This is a potential candidate, look for a more recent one to the right
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                // Too far in the future, look left
                right = mid - 1;
            }
        }
        
        return res;
    }
}
