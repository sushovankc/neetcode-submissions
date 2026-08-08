class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr: prerequisites){
            int pre = arr[1];
            int sub = arr[0];

            adj.get(pre).add(sub);
            indegree[sub]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int completed = 0;
        while(!q.isEmpty()){
            int sub = q.poll();
            completed++;            
            for(int i : adj.get(sub)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }

        return completed == numCourses;
    }
}
