class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
