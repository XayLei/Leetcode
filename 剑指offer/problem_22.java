import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int length = pushA.length;
        boolean re = false;
        if(pushA != null && popA != null && length>0){
            int i = 0 , j = 0;
            Stack<Integer> stack = new Stack<>();
            while(j < length){
                while(stack.isEmpty() || stack.peek() != popA[j]){ //如果辅助栈为空或者是辅助栈的栈顶元素与弹出数组元素不同
                    if(i  >= length) break; //当i大于数组长度时，说明已经没有可以压入栈的元素了，则直接终止循环
                    stack.push(pushA[i]);
                    i++;
                }
                
                //这一步的判断是因为，上一个while循环中，当i到达最大值时，
				//直接break退出了，说明压入数组中已为空，
				//这时在这判断辅助栈顶是否与弹出数组中的下一个元素相同，
				//如果不同，则直接退出，说明两个输入数组不匹配
                if(stack.peek() != popA[j]) break;
				
                stack.pop();
                j++;
            }
            if(stack.isEmpty() && j == length) re = true;
        }
        return re;
    }
}