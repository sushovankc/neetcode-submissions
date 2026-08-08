class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0;r<grid.length;r++){
            for(int c = 0;c<grid[0].length;c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }

        bfs(grid,q);

    }

    public void bfs(int[][] grid,Queue<int[]> q){

        while(!q.isEmpty()){

            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir: directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 2147483647){
                    grid[nr][nc] = grid[row][col] + 1;
                    q.add(new int[]{nr,nc});
                }
            }

        }

    }
}
