class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    int minElement = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (val <= minElement) {
            stack.push(minElement);
            minElement = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if (stack.pop() == minElement) {
            minElement = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minElement;
    }
}
