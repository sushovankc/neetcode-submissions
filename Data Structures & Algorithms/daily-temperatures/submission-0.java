class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        // for(int i = 0;i<temperatures.length;i++){
        //     if(!stack.isEmpty()){
        //         if(stack.peek()>temperatures[i]){

        //         }
        //     }
        // }

        int l = 0, r = 1;
        while(l<temperatures.length-1){
            if(temperatures[l] < temperatures[r]){
                res[l] = r-l;
                l++;
                r = l + 1;
            }else{
                r++;
                if(r == temperatures.length){
                    res[l] = 0;
                    l++;
                    r = l+1;
                }                
            }
        } 
        res[temperatures.length-1] = 0;

        return res;
    }
}
