class Solution {
    int minutes = 0, fresh = 0;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < grid.length;r++){
            for(int c = 0; c < grid[0].length;c++){
                if(grid[r][c] == 1){
                    fresh++;
                }else if(grid[r][c] == 2){
                    q.add(new int[]{r,c});
                }
            }
        }

        bfs(grid, q);


        return fresh == 0 ? minutes:-1;
        
    }

    public void bfs(int[][] grid, Queue<int[]> q){

        while( fresh > 0 && !q.isEmpty()){
            
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];

                for(int[] dir: directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >= 0 && nc >=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            minutes++;            
        }
    }
}
