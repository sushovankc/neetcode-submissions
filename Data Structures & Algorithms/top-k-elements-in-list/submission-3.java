class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i,map.get(i)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        List<Integer> sub = list.subList(0,k);
        int cnt = 0;
        for(Map.Entry<Integer,Integer> ent : map.entrySet()){
            if(sub.contains(ent.getValue())){
                result[cnt] = ent.getKey();
                cnt++;
            }
        }

        return result;
    }
}
