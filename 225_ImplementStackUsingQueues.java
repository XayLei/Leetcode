public class MyStack {

    Deque<Integer> queue;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.push(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size()==0 ? true : false;
    }
}