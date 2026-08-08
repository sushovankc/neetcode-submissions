class Solution {

    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {

        int ROWS = board.length, COLS = board[0].length;
        boolean[][] isSafe = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){

            if(board[r][0] == 'O'){
                dfs(board,r,0,isSafe);   
            }

            if(board[r][COLS-1] == 'O'){
                dfs(board,r,COLS-1,isSafe);
            }
            
        }

        for(int c = 0; c < COLS; c++){
            if(board[0][c] == 'O'){
                dfs(board,0,c,isSafe);
            }
            
            if(board[ROWS-1][c] == 'O'){
                dfs(board,ROWS-1,c,isSafe);
            }
            
        }

        for(int r = 0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(!isSafe[r][c]){
                    board[r][c] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, int r, int c, boolean[][] isSafe){

        isSafe[r][c] = true;

        for(int[] dir: directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && !isSafe[nr][nc] && board[nr][nc] == 'O'){
                dfs(board,nr,nc,isSafe);
            } 
        }
        
    }
}
