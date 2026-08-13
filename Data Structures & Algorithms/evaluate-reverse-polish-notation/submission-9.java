class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack<>();

       for(String s : tokens){
        if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
            stack.push(Integer.parseInt(s));
        }else{
            int pop1 = stack.pop();
            int pop2 = stack.pop();
            
            if(s.equals("+")){
                stack.push(pop2 + pop1);
            }else if(s.equals("-")){
                stack.push(pop2 - pop1);
            }else if(s.equals("*")){
                stack.push(pop2 * pop1);
            }else{
                stack.push(pop2 / pop1);
            }
        }
       } 
        return stack.pop();
    }
}
