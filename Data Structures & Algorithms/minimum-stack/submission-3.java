class MinStack {

    Stack<Integer> stk1;
    Stack<Integer> minStack;
    public MinStack() {
        this.stk1 = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stk1.push(val);
        if(!minStack.isEmpty()){
            int minVal = minStack.peek();
            if(val <= minVal) minStack.push(val);
        }else{
            minStack.push(val);
        }
    }
    
    public void pop() {
       int popped = stk1.pop();
       if(minStack.peek() == popped) minStack.pop(); 
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
