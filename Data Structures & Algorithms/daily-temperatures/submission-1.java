class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }

        return res;
        
        // int l = 0, r = 1;
        // while(l<temperatures.length-1){
        //     if(temperatures[l] < temperatures[r]){
        //         res[l] = r-l;
        //         l++;
        //         r = l + 1;
        //     }else{
        //         r++;
        //         if(r == temperatures.length){
        //             res[l] = 0;
        //             l++;
        //             r = l+1;
        //         }                
        //     }
        // } 
        // res[temperatures.length-1] = 0;

    }
}
