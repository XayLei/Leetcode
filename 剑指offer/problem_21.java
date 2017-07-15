import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();
    int min = 0;
    public void push(int node) {
        if(stack.isEmpty()){
            min = node;
            stack.push(0);
        }else{
            stack.push(node-min); //如果node大于min，则压入的是个正数，min不会被更新
            if(node<min) min = node;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int num = stack.pop();
        if(num<0){
            min = min + Math.abs(num);
        }
    }
    
    public int top() {
        int num = stack.peek();
        if(num<0){ //如果num小于0，则说明之前压入了一个最小值，即栈顶为最小值，则直接返回最小值即可
            return min;
        }else{
            return (min+num);
        }
    }
    
    public int min() {
        return min;
    }
}