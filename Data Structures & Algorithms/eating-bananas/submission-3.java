class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length - 1];
        int minK = max;
        int l = 1, r = max;

        while(l<=r){
            int mid = l + (r - l) / 2;

            double hrs = 0;

            for(int pile:piles){
                double time = Math.ceil((double)pile / mid);
                hrs += time;
            }

            if(hrs <= h){
                minK = Math.min(minK,mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return minK;
    }
}
