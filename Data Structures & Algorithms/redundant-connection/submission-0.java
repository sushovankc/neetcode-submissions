class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            // Before adding edge, check if cycle already exists between these two nodes
            boolean[] visited = new boolean[n + 1];
            if (hasPath(adj, visited, edge[0], edge[1])) {
                return edge; // This edge creates a cycle, and since we go in order, it's the last
            }
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return new int[]{};
    }

    private boolean hasPath(List<List<Integer>> adj, boolean[] visited, int src, int target) {
        if (src == target) return true;
        visited[src] = true;
        for (int neighbor : adj.get(src)) {
            if (!visited[neighbor]) {
                if (hasPath(adj, visited, neighbor, target)) return true;
            }
        }
        return false;
    }
}