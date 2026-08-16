class TimeMap {

    HashMap<String,String> map = new HashMap<>();
    Map<String, List<Integer>> timeMap = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timeStamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key,new ArrayList<>());
        }

        timeMap.get(key).add(timeStamp);
        map.put(key+timeStamp+"",value);
    }
    
    public String get(String key, int timeStamp) {
        if(map.containsKey(key+timeStamp+"")){
            return map.get(key+timeStamp+"");
        }else{
            List<Integer> times = timeMap.getOrDefault(key, new ArrayList<>());

            int l = 0, r = times.size() - 1, res = Integer.MAX_VALUE;

            while(l <= r){
                int mid = l + (r - l) / 2;

                if(times.get(mid) < timeStamp){
                    res = times.get(mid);
                    l = mid + 1;
                }else{
                    r = mid - 1; 
                }
            }

            return res == Integer.MAX_VALUE ? "":map.get(key+res+"");
        }
    }
}
