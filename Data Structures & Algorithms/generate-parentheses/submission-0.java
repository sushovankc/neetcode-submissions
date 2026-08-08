class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }

    public void backtrack(List<String> res, String s, int l, int r, int n){
        if(s.length() == 2*n){
            res.add(s);
            return;
        }

        if(l<n){
            backtrack(res,s+'(',l+1,r,n);
        }

        if(r<l){
            backtrack(res,s+')',l,r+1,n);
        }
    }
}
