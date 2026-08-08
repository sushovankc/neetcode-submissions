class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[edges.length + 1];

        for(int i = 0; i <= edges.length; i++){
            parent[i] = i;  // each node is its own boss
        }

        for(int[] edge:edges){
            if(find(edge[0]) == find(edge[1])) return edge;

            union(edge[0],edge[1]);
        }
        return new int[2];
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        parent[parentY] = parentX;
    }

}
