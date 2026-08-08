class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(adj,visited,0);

        for(boolean status: visited){
            if(!status) return false;
        }

        return true;
    }

    public void dfs(List<List<Integer>> adj, boolean[] visited, int node){

        if(visited[node]) return;
        visited[node] = true;

        for(int i : adj.get(node)){
            dfs(adj,visited,i);
        }
    }
}
