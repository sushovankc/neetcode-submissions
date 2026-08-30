class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if(first != second){
                maxHeap.add(first-second);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
        
    }
}
