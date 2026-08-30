class KthLargest {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int cnt;
    public KthLargest(int k, int[] nums) {
        this.cnt = k;
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
       minHeap.add(val);
       if(minHeap.size() > cnt){
        minHeap.poll();
       }

       return minHeap.peek();

    }
}
