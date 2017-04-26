public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();  //利用双端队列的性质，模拟一个栈
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        
        String[] path1 = path.split("/");
        for(int i=0; i<path1.length; i++){
            if(path1[i].equals("..") && !stack.isEmpty()){ //如果出现".."，并且栈不为空，则弹出栈中最上面的元素
                stack.pop();
            }else if(!skip.contains(path1[i])){ //判断子字符串不是("..",".","")中的任意一个，则将这个元素压入栈中
                stack.push(path1[i]);
            }
        }
        
        String s = "";
        for(String str : stack){
            s = "/" + str + s;
        }
        
		/*
		最后这里是为了解决这种情况：
		   Did you consider the case where path = "/../"?
           In this case, you should return "/".
		   
		   "/../"最终就变成了""==s
		   所以要判断S是否为空，为空的话就直接返回"/"
		   不为空的话就返回S
		*/
        return s.isEmpty() ? "/" : s;
    }
}