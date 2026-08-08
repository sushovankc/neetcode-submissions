class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        List<Integer> list2 = list.subList(0,k);
        int i = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(list2.contains(entry.getValue())){
                result[i] = entry.getKey();
                i++;
            }
        }
        return result;  
    }
}
