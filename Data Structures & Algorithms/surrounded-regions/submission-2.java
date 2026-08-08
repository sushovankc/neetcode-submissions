class Solution {

    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {

        int ROWS = board.length, COLS = board[0].length;
        boolean[][] isSafe = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){

            if(board[r][0] == 'O'){
                dfsInPlace(board,r,0);   
            }

            if(board[r][COLS-1] == 'O'){
                dfsInPlace(board,r,COLS-1);
            }
            
        }

        for(int c = 0; c < COLS; c++){
            if(board[0][c] == 'O'){
                dfsInPlace(board,0,c);
            }
            
            if(board[ROWS-1][c] == 'O'){
                dfsInPlace(board,ROWS-1,c);
            }
            
        }

        for(int r = 0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == '#'){
                    board[r][c] = 'O';
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

    public void dfsInPlace(char[][] board, int r, int c){

        board[r][c] = '#';

        for(int[] dir: directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O'){
                dfsInPlace(board,nr,nc);
            } 
        }
        
    }
}
