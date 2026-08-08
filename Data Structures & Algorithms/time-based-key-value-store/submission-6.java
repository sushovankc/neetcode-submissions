class TimeMap {

    HashMap<String, String> map;
    HashMap<String,List<Integer>> timeMap;

    public TimeMap() {
        map = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(timestamp);

        map.put(key + timestamp + "",value);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key+timestamp+"")){
            return map.get(key+timestamp+"");
        }else{
            List<Integer> arr = timeMap.getOrDefault(key, new ArrayList<>());
            int l = 0,r = arr.size()-1;
            int res = Integer.MAX_VALUE;

            while(l<=r){
                int mid = (l+r)/2;
                if(arr.get(mid) <= timestamp){
                    res = arr.get(mid);
                    l = mid +1;
                }else{
                    r = mid - 1;
                }
            }

            return res == Integer.MAX_VALUE ? "" : map.get(key+res+"");
            
        }
    }


}
