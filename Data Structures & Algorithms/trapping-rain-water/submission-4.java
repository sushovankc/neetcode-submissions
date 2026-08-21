class Solution {
    public int trap(int[] height) {

        if(height == null || height.length == 1) return 0;

        int l = 0, r = height.length - 1;

        int maxL = height[l], maxR = height[r];
        int total = 0;

        while(l < r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                total += maxL - height[l];
            }else{
                r--;
                maxR = Math.max(maxR,height[r]);
                total += maxR - height[r];
            }
        }

        return total;
    }
}
