class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!large.isEmpty() && num > large.peek()){
            large.add(num);
        }else{
            small.add(num);
        }

        if(small.size()-large.size()>1){
            int max = small.poll();
            large.add(max);
        }else if(large.size() - small.size() > 1){
            int min = large.poll();
            small.add(min);
        }
    }
    
    public double findMedian() {
        int sSize = small.size();
        int lSize = large.size();

        if(sSize == lSize){
            int max = small.peek();
            int min = large.peek();
            double res = (max + min) / 2.0;
            return res;
        }else{
            if(sSize > lSize){
                double res = (double) small.peek();
                return res;
            }else{
                double res = (double) large.peek();
                return res;
            }
        }
    }
}
