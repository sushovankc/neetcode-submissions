class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time:times){
            int from = time[0];
            int to = time[1];
            int w = time[2];

            adj.get(from).add(new int[]{to,w});
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        HashSet<Integer> visited = new HashSet<>();

        minHeap.add(new int[]{0,k});
        int time = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int w1 = cur[0], n1 = cur[1];

            if(visited.contains(n1)){
                continue;
            }
            visited.add(n1);
            time = w1;
            for(int[] neighbor:adj.get(n1)){
                int n2 = neighbor[0];
                int w2 = neighbor[1];

                if(!visited.contains(n2)){
                    minHeap.add(new int[]{w1+w2,n2});
                }
            }
        }

        return visited.size() == n? time:-1;
    }
}
