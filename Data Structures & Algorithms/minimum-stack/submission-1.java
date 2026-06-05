class MinStack {
    int minElement = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

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
