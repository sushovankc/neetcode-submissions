class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        int res = 0;

        for(String s: tokens){
            if(s.equals("+")){
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                System.out.println(stack.toString() +" from +");
                res = first+second;
                stack.push(res+"");
            }else if(s.equals("-")){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                System.out.println(stack.toString() +" from -");
                res = first-second;
                stack.push(res+"");
            }else if(s.equals("*")){
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                System.out.println(stack.toString() +" from *");
                res = first*second;
                stack.push(res+"");
            }else if(s.equals("/")){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                System.out.println(stack.toString() +" from /");
                res = first/second;
                stack.push(res+"");
            }else{
                stack.push(s);
                System.out.println(stack.toString() + " from Digit");
            
            }       
        }

        return Integer.parseInt(stack.peek());
    }
}
