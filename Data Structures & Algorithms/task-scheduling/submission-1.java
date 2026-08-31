class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        for(char c : tasks){
            arr[c-'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i:arr){
            if(i != 0) maxHeap.add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }else{
                int task = maxHeap.poll() - 1;
                if(task > 0){
                    q.add(new int[]{task,time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
