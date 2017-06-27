public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
			//���������ջ�����ԣ����ջΪ�գ�˵��û�гɶԵ����ţ����ջ��Ϊ�գ����ǽ�������������ȴ�������Ų�ƥ�䣬ֱ�ӷ���false	
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}