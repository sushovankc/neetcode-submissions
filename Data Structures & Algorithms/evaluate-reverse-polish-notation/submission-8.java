class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for(String s: tokens){
            if(s.equals("+")){
                int first = (stack.pop());
                int second = (stack.pop());
                res = first+second;
                stack.push(res);
            }else if(s.equals("-")){
                int second = (stack.pop());
                int first = (stack.pop());
                res = first-second;
                stack.push(res);
            }else if(s.equals("*")){
                int first = (stack.pop());
                int second = (stack.pop());
                res = first*second;
                stack.push(res);
            }else if(s.equals("/")){
                int second = (stack.pop());
                int first = (stack.pop());
                res = first/second;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(s));            
            }       
        }

        return stack.peek();
    }
}
