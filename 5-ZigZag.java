public class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows==0)
            return "";
        if(numRows==1)  return s;
        
        int size = 2*numRows-2;
        StringBuilder sb = new StringBuilder();

        //遍历行
        for(int i=0; i<numRows; i++){
            //遍历列
            for(int j=i; j<s.length(); j+=size){
                sb.append(s.charAt(j));
                //排除第一行和最后一行，计算斜线上的索引号
                if(i!=0 && i!=numRows-1){
                    int temp = j + size - 2*i;
                    if(temp<s.length()){
                        sb.append(s.charAt(temp));
                    }
                }
            }
        }
        return sb.toString();
    }
}
