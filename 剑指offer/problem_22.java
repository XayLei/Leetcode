import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int length = pushA.length;
        boolean re = false;
        if(pushA != null && popA != null && length>0){
            int i = 0 , j = 0;
            Stack<Integer> stack = new Stack<>();
            while(j < length){
                while(stack.isEmpty() || stack.peek() != popA[j]){ //�������ջΪ�ջ����Ǹ���ջ��ջ��Ԫ���뵯������Ԫ�ز�ͬ
                    if(i  >= length) break; //��i�������鳤��ʱ��˵���Ѿ�û�п���ѹ��ջ��Ԫ���ˣ���ֱ����ֹѭ��
                    stack.push(pushA[i]);
                    i++;
                }
                
                //��һ�����ж�����Ϊ����һ��whileѭ���У���i�������ֵʱ��
				//ֱ��break�˳��ˣ�˵��ѹ����������Ϊ�գ�
				//��ʱ�����жϸ���ջ���Ƿ��뵯�������е���һ��Ԫ����ͬ��
				//�����ͬ����ֱ���˳���˵�������������鲻ƥ��
                if(stack.peek() != popA[j]) break;
				
                stack.pop();
                j++;
            }
            if(stack.isEmpty() && j == length) re = true;
        }
        return re;
    }
}