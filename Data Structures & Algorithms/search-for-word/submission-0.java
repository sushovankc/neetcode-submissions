class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        // Try starting from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0, visited)) {
                    return true; // Found the word
                }
            }
        }
        return false; // Word not found
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index, boolean[][] visited) {
        // Success: matched entire word
        if (index == word.length()) {
            return true;
        }
        
        // Failure: out of bounds, visited, or char mismatch
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length 
            || visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Mark current cell as visited
        visited[r][c] = true;
        
        // Explore 4 directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (dfs(board, word, nr, nc, index + 1, visited)) {
                return true; // Early return on success
            }
        }
        
        // Backtrack: unmark visited
        visited[r][c] = false;
        return false;
    }
}
