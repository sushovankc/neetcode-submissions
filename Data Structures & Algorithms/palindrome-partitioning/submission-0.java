class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s,res,new ArrayList<>(),0);
        return res;
    }

    public void backtrack(String s, List<List<String>> res, List<String> set, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(set));
            return;
        }

        for(int i = start; i < s.length();i++){
            if(isPalindrome(s.substring(start,i+1))){
                set.add(s.substring(start,i+1));
                backtrack(s,res,set,i+1);
                set.remove(set.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
