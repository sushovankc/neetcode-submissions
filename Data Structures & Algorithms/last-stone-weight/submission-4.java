class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            maxHeap.add(i);
        }

        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if(first == second){
                continue;
            }else{
                maxHeap.add(first - second);
            }
        }

        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}
