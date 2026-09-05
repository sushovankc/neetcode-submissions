class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length - 1];
        int res = max;
        int l = 1,r = max;
        while(l <= r){
            int mid = (l+r)/2;

            int time = 0;

            for(int i =0;i<piles.length;i++){
                time += Math.ceil((double)piles[i]/mid);
            }

            if(time <= h){
                res = Math.min(res,mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        return res;
        
    }
}
