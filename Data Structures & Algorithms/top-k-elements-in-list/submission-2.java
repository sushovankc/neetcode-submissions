class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        List<Integer> sl = new ArrayList<>(map.values());
        Collections.sort(sl,Collections.reverseOrder());
        List<Integer> l = sl.subList(0,k);

        int[] res = new int[k];
        int i = 0;

        for(Map.Entry<Integer,Integer> ent : map.entrySet()){
            if(l.contains(ent.getValue())){
                res[i] = ent.getKey();
                i++;
            }
        }

        return res;
    }
}
