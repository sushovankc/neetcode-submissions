class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String,PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets){
            if(!adj.containsKey(ticket.get(0))){
                adj.put(ticket.get(0),new PriorityQueue<>());
            }
            adj.get(ticket.get(0)).add(ticket.get(1));            
        }
        
        dfs(res,adj,"JFK");

        Collections.reverse(res);
        return res;
    }

    public void dfs(List<String> res,  Map<String,PriorityQueue<String>> adj, String start ){

        if(adj.get(start) != null){
            PriorityQueue<String> nextDest = adj.get(start);

            while(!nextDest.isEmpty()){
                String dest = nextDest.poll();
                dfs(res,adj,dest);
            }

        }
        res.add(start);      
    }
}
