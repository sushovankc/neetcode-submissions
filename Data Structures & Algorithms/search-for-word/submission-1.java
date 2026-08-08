class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        boolean[][] visited = new boolean[rows][columns];

        for(int r = 0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(dfs(board,r,c,0,visited,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int i, boolean[][] visited,String word){
        if(i == word.length()){
            return true;
        }

        if(r<0 || c<0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(i)){
            return false;
        }

        visited[r][c] = true;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int d = 0;d<4;d++){
            int row = r+dr[d];
            int col = c+dc[d];

            if(dfs(board,row,col,i+1,visited,word)){
                return true;
            }
        }

        visited[r][c] = false;
        return false;
    }
}
