class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board[0].length;j++){
                char curChar = board[i][j];

                if(curChar != '.'){
                    if(!set.add(curChar + "row" + i) || !set.add(curChar + "col" + j) || !set.add(curChar + "box" + i/3 + j/3) ){
                        return false;  
                    }
                }
            }
        }
        return true;
    }
}
