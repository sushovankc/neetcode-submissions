class Solution {
    public int characterReplacement(String s, int k) {
        if(k == s.length()) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0 , maxFreq = 0, res = 0;
        while(r < s.length()){

            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            while((r-l+1) - maxFreq > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }

            res = Math.max(res,r - l + 1);
            r++;          
            
        }

        return res;
    }
}
