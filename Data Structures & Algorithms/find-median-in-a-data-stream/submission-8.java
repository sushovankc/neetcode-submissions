class MedianFinder {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Stores larger half
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // stores smaller half
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            minHeap.add(num);
            return;
        }

        if(num > minHeap.peek()){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }

        if(Math.abs(minHeap.size()-maxHeap.size())>1){
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }else{
                minHeap.add(maxHeap.poll());
            }
        }
        
    }
    
    public double findMedian() {

        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }

        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
        
    }
}
