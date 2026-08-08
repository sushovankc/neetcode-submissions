class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        minHeap.add(new int[]{grid[0][0],0,0});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!minHeap.isEmpty()){
            int[] polled = minHeap.poll();
            int curTime = polled[0];
            int r = polled[1];
            int c = polled[2];
            visited[r][c] = true;

            if(r == N-1 && c == N-1){
                return curTime;
            }

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >=0 && nc >=0 && nr<grid.length && nc < grid[0].length && !visited[nr][nc]){
                    int nt = Math.max(curTime,grid[nr][nc]);
                    minHeap.add(new int[]{nt,nr,nc});
                }            
            }
        }

        return -1;
    }
}
