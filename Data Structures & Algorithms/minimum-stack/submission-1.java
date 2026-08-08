class MinStack {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {        
    }
    
    public void push(int val) {
        pushStack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(pushStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        pushStack.pop();
    }
    
    public int top() {
        return pushStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
