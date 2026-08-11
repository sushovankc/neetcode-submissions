class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        HashSet<Character> set = new HashSet<>();
        int longestSub = 0, l = 0, r = 0;

        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            longestSub = Math.max(longestSub, r - l + 1);
            r++;
        }
        return longestSub;
    }
}
