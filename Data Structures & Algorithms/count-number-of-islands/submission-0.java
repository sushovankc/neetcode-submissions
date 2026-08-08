class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}; 
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int islands = 0;

        for(int r = 0; r< row;r++){
            for(int c = 0;c< col; c++){
                if(grid[r][c] == '1'){
                    dfs(r,c,grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int r, int c, char[][] grid){
        if(r<0 || c<0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        for(int[] d : dir){
            dfs(r + d[0], c + d[1], grid);
        }
    }
}
