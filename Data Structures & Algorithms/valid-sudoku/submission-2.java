class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();

        for(int r = 0 ; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] != '.'){
                    if(!set.add(board[r][c] + " " + r + " row ") || !set.add(board[r][c] + " " + c + " col") || !set.add(board[r][c] + " " + r/3 + " x " + c/3)){
                    return false;
                
                }
                }
            }
        }

        return true;

    }
}
