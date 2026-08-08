class Solution {

    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        for(int c = 0;c < heights[0].length;c++){
            dfs(heights,0,c,pac);
            dfs(heights,heights.length - 1,c,atl);
        }
        for(int r = 0;r < heights.length;r++){
            dfs(heights,r,0,pac);
            dfs(heights,r,heights[0].length - 1,atl);
        }

        for(int r = 0;r<heights.length;r++){
            for(int c = 0; c< heights[0].length;c++){
                if(pac[r][c] && atl[r][c]){
                    List<Integer> lis = new ArrayList<>();
                    lis.add(r);
                    lis.add(c);
                    res.add(lis);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] ocean){

        ocean[r][c] = true;

        for(int[] dir: directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            // if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length){
            //     continue;
            // }

            // if(ocean[nr][nc]) continue;

            if(nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(heights,nr,nc,ocean);
            }
        }
    }
}
