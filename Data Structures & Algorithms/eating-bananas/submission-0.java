class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        Arrays.sort(piles);
        int l = 1, r = piles[piles.length-1];

        while(l<=r){
            int mid = (l+r)/2;
            int totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil((double) p/mid);
            }

            if(totalTime <= h){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return res;
    }
}
