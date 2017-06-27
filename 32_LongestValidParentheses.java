public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0; //用于存储最长子串
        int left = -1; //左指针
        for(int j=0;j<s.length();j++){ //遍历字符串中的每个字符
            if(s.charAt(j)=='(') stack.push(j);   //如果第J个字符是左括号，则向栈中压入索引J          
            else { //如果不是左括号，即J为右括号
                if (stack.isEmpty()) left=j; //栈为空，即在遍历字符串到索引J时，还没有遇到过左括号，遇到的全是右括号，则将指针移至J
                else{ //如果栈不为空，即在遍历过的字符串中，已经遇到过左括号
                    stack.pop(); //弹出最近遇到的左括号索引
                    if(stack.isEmpty()) max=Math.max(max,j-left); //如果栈为空，最长子串就是J与左指针的差，此行说明更新的最长子串长度还是同一子串的，例如“)()()(”,"()()"的长度就一直会在此行更新
                    else max=Math.max(max,j-stack.peek()); //否则，最长子串为J与栈顶索引的差，此行处理类似于“)((()))(”这样的例子
                }
            }
        }
        return max;
    }
}