class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        char[] arrS1 = s1.toCharArray();
        Arrays.sort(arrS1);
        String s = new String(arrS1);
        int win = s1.length();
        int l=0,r=win;

        while(l<=r && r<=s2.length()){
            String sub = s2.substring(l,r);
            char[] arrSub = sub.toCharArray();
            Arrays.sort(arrSub);
            String sub2 = new String(arrSub);
            if(s.equals(sub2)){
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
