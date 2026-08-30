class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] res = new int[k][2];
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b)->(Integer.compare(b[0] * b[0] + b[1] * b[1],a[0] * a[0] + a[1] * a[1])));

        for(int[] arr: points){
            maxHeap.add(arr);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int c = 0;
        while(!maxHeap.isEmpty()){
            int[] poll = maxHeap.poll();
            res[c][0] = poll[0];
            res[c][1] = poll[1];
            c++;
        }

        return res;
    }
}
