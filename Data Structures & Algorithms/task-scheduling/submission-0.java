class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char c: tasks){
            count[c-'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : count){
            if(i>0){
                heap.add(i);
            }
        }

        Queue<int[]> timer = new LinkedList<>();
        int time = 0;

        while(!heap.isEmpty() || !timer.isEmpty()){

            time++;

            if(heap.isEmpty()){
                time = timer.peek()[1];
            }else{
                int curTask = heap.poll() - 1;
                if(curTask > 0){
                    timer.add(new int[]{curTask,time + n});
                }
                
            }

            if(!timer.isEmpty() && timer.peek()[1] == time){
                heap.add(timer.poll()[0]);
            }
        }

        return time;

    }
}
