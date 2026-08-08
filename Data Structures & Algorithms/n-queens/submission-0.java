class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] col = new boolean[2*n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];
        backtrack(n,res,new ArrayList<>(),0,col,diag1,diag2);
        return res;

    }

    public void backtrack(int n, List<List<String>> res, List<String> sol, int row,boolean[] col,boolean[] diag1,boolean[] diag2){
        if(sol.size() == n){
            res.add(new ArrayList<>(sol));
            return;
        }

        for(int i = 0;i<n;i++){
            if(!col[i] && !diag1[row-i+n-1] && !diag2[row+i] ){
                String pos = "";
                for(int j = 0;j<n;j++){
                    if(j == i){
                        pos = pos + 'Q';
                    }else{
                        pos = pos + '.';
                    }
                }
                col[i] = true;
                diag1[row - i + n - 1] = true;
                diag2[row + i] = true;
                sol.add(pos);
                backtrack(n,res,sol,row+1,col,diag1,diag2);
                sol.remove(sol.size()-1);
                col[i] = false;
                diag1[row - i + n - 1] = false;
                diag2[row + i] = false;
            }
        }

    }
}
