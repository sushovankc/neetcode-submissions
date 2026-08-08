class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Double, ArrayList<int[]>> disMap = new HashMap<>();
        for(int[] i:points){
            double dist = Math.sqrt(i[0]*i[0] + i[1] * i[1]);
            if(disMap.containsKey(dist)){
                disMap.get(dist).add(i);
            }else{
                disMap.put(dist,new ArrayList<>());
                disMap.get(dist).add(i);
            }
            maxHeap.add(dist);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

       int i = 0;
       while(i<k){
        ArrayList<int[]> list = disMap.get(maxHeap.poll());
        // int[] arr = disMap.get(maxHeap.poll());
        if(list.size() == 1){
            int[] arr = list.get(0);
            res[i][0] = arr[0];
            res[i][1] = arr[1];
        }else if(list.size() == 2){
            for(int[] arr:list){
                res[i][0] = arr[0];
                res[i][1] = arr[1];
                i++; 
            }
        }        
        i++;
       }

        return res;
    }
}
