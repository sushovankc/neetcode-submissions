class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0;i<heights.length;i++){
            int start = i;

            while(!stack.isEmpty() && heights[i] < stack.peek()[1]){
                int[] popped = stack.pop();
                int idx = popped[0];
                int hgt = popped[1];

                maxArea = Math.max(maxArea, hgt * (i-idx));
                start = idx;
            }

            stack.push(new int[]{start,heights[i]});
        }

        for(int[] pair: stack){
            int indx = pair[0];
            int hgt = pair[1];

            maxArea = Math.max(maxArea, hgt * (heights.length - indx));
        }

        return maxArea;
    }
}
