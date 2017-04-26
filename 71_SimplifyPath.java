public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();  //����˫�˶��е����ʣ�ģ��һ��ջ
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        
        String[] path1 = path.split("/");
        for(int i=0; i<path1.length; i++){
            if(path1[i].equals("..") && !stack.isEmpty()){ //�������".."������ջ��Ϊ�գ��򵯳�ջ���������Ԫ��
                stack.pop();
            }else if(!skip.contains(path1[i])){ //�ж����ַ�������("..",".","")�е�����һ���������Ԫ��ѹ��ջ��
                stack.push(path1[i]);
            }
        }
        
        String s = "";
        for(String str : stack){
            s = "/" + str + s;
        }
        
		/*
		���������Ϊ�˽�����������
		   Did you consider the case where path = "/../"?
           In this case, you should return "/".
		   
		   "/../"���վͱ����""==s
		   ����Ҫ�ж�S�Ƿ�Ϊ�գ�Ϊ�յĻ���ֱ�ӷ���"/"
		   ��Ϊ�յĻ��ͷ���S
		*/
        return s.isEmpty() ? "/" : s;
    }
}