class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
          adj.add(new ArrayList<>());
        }

        for(int[] flight:flights){
          int origin = flight[0];
          int dest = flight[1];
          int price = flight[2];

          adj.get(origin).add(new int[]{dest,price});
        }
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});

        int curK=0;
        while(!q.isEmpty() && curK <= k){
          int size = q.size();

          for(int i = 0;i<size;i++){
            int[] polled = q.poll();
            int node = polled[0];
            int cost = polled[1];

            for(int[] neighbor : adj.get(node)){
              int neiNode = neighbor[0];
              int costNeig = neighbor[1];

              if(cost + costNeig < prices[neiNode]){
                prices[neiNode] = cost + costNeig;
                q.add(new int[]{neiNode, prices[neiNode]});
              }
            }
          }
          curK++;
        }

        return prices[dst] == Integer.MAX_VALUE?-1:prices[dst];
    }
}
