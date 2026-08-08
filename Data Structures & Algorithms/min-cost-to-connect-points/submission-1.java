class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int i = 0;i<N;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i+1;j<N;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist,i});
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        minHeap.add(new int[]{0,0});

        while(visited.size() < N){
            int[] polled = minHeap.poll();
            int weight = polled[0], node = polled[1];
            if(!visited.contains(node)){
                visited.add(node);
                res += weight;

                for(int[] neighbor : adj.getOrDefault(node,new ArrayList<>())){
                    int neiWeight = neighbor[0];
                    int neiNode = neighbor[1];

                    if(!visited.contains(neiNode)){
                        minHeap.add(new int[]{neiWeight,neiNode});
                    }
                }
            }
        }

        return res;
    }
}
