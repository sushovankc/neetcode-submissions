class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int total = 0;

        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
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
