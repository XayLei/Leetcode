public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list,"",0,0,n);
        return list;
    }
    
	//�˴���String����ʹ��StringBuilder���棬�����ֻ��õ�һ����Ͻ��
    public void backTrack(List<String> list,String str,int open,int close,int n){
        if(str.length()==2*n){
            list.add(str);
            return;
        }
        
        //��������ŵĸ������ڸ��������Ŷ���n�������������
        if(open < n){
            backTrack(list,str+"(",open+1,close,n);
        }
        //��������ŵĸ������������Ÿ����������������
        if(close < open){
            backTrack(list,str+")",open,close+1,n);
        }
    }
}