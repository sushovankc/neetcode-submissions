class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while( l <= r){
            char lchar = s.charAt(l);
            char rchar = s.charAt(r);
            if(!Character.isLetterOrDigit(lchar)){
                l++;
            }else if(!Character.isLetterOrDigit(rchar)){
                r--;
            }else{
                if(lchar != rchar){
                    return false;
                }else{
                    l++;
                    r--;
                }
            }
        }

        return true;
    }
}
