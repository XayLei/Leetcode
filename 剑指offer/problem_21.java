import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();
    int min = 0;
    public void push(int node) {
        if(stack.isEmpty()){
            min = node;
            stack.push(0);
        }else{
            stack.push(node-min); //���node����min����ѹ����Ǹ�������min���ᱻ����
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
        if(num<0){ //���numС��0����˵��֮ǰѹ����һ����Сֵ����ջ��Ϊ��Сֵ����ֱ�ӷ�����Сֵ����
            return min;
        }else{
            return (min+num);
        }
    }
    
    public int min() {
        return min;
    }
}