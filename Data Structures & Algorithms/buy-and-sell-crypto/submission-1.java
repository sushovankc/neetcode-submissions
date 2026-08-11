class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r= 1;
        int mPro = 0;

        while(r < prices.length){
            if(prices[r] > prices[l]){
                mPro = Math.max(mPro,prices[r] - prices[l]);
                r++;
            }else{
                l = r;
                r++;
            }
        }

        return mPro;
    }
}
