class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int l = 0, r = heights.length - 1;

        while(l<r){
            int curArea = Math.min(heights[l],heights[r]) * (r-l);
            if(curArea>max){
                max = curArea;
            }
            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
        }

        return max;
    }
}
