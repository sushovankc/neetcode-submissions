class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0, maxf = 0, ans = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));

            // Check if current window has only k replacements available
            while((r-l+1) - maxf > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }
}
