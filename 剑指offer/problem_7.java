import java.util.Stack;

//������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
       
    }
    
    public int pop() {
        if(stack2.empty()){  //��ѹ��ջ2ʱ��Ҫ���ж��Ƿ�Ϊ�գ������ʧ��
        	while(!stack1.empty()){
            	stack2.push(stack1.pop());
        	} 
        }
        return stack2.pop();
    }
}