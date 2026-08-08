class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String nS = new String(cArr);

            if(!map.containsKey(nS)){
                map.put(nS,new ArrayList<>());
            }    
            map.get(nS).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
