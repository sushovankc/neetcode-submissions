class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int l = 0, r = 1;
        int longest = 1, curLen = 1;
        Set<Character> set = new HashSet<>();
        while(r<s.length()){
            set.add(s.charAt(l));
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
                curLen++;                
            }else{
                l++;
                r = l+1;
                curLen = 1;
                set.clear();
            }
            longest = Math.max(longest,curLen);
        }

        return longest;
    }
}
