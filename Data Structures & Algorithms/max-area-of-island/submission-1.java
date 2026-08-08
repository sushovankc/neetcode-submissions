class Solution {
    int maxArea = 0, cur = 0;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(grid[r][c] == 1){
                    dfs(grid,r,c);
                    cur = 0;
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>= grid[0].length || grid[r][c] == 0){
            return;
        }

        cur++;
        if(cur > maxArea){
            maxArea = cur;
        }

        grid[r][c] = 0;

        for(int[] dir: directions){
            dfs(grid,r + dir[0], c + dir[1]);
        }
    }
}

/*grid=[
[0,0,1,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,1,1,0,1,0,0,0,0,0,0,0,0],
[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],
[0,0,0,0,0,0,0,0,0,0,1,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,0,0,0,0,0,0,1,1,0,0,0,0]]
*/
