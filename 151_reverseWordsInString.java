public class Solution {
    public String reverseWords(String s) {
        if(s==null) return null;
        
        //注意这里的正则表达式，这里代表空格出现1次或多次
        String[] sArr = s.split(" +");
        int i = 0;
        int j = sArr.length-1;
        while(i < j){
            String temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            i++;
            j--;
        }
        
        StringBuilder sNew = new StringBuilder();
        for(int k =0; k < sArr.length; k++){
            sNew.append(sArr[k]);
            sNew.append(" ");
        }
        
        return sNew.toString().trim();
    }
}
