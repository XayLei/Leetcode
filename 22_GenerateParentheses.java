public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list,"",0,0,n);
        return list;
    }
    
	//此处的String不能使用StringBuilder代替，否则就只会得到一种组合结果
    public void backTrack(List<String> list,String str,int open,int close,int n){
        if(str.length()==2*n){
            list.add(str);
            return;
        }
        
        //如果左括号的个数少于给定的括号对数n，则添加左括号
        if(open < n){
            backTrack(list,str+"(",open+1,close,n);
        }
        //如果右括号的个数少于左括号个数，则添加右括号
        if(close < open){
            backTrack(list,str+")",open,close+1,n);
        }
    }
}