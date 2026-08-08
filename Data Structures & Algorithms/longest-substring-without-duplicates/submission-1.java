class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int l = 0, r = 1;
        int longest = 0, curLen = 0;
        Set<Character> set = new HashSet<>();
        while(r<s.length()){
            set.add(s.charAt(l));
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
                curLen++;
                System.out.println(curLen);                
                System.out.println(set);
                
            }else{
                l++;
                r = l+1;
                curLen = 0;
                set.clear();
            }
            longest = Math.max(longest,curLen);
            System.out.println(longest + " when l is " + l);
        }

        return longest+1;
    }
}
