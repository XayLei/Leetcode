public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer str1 = new StringBuffer();
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                str1.append("%20");
            }else{
                str1.append(str.charAt(i));
            }
        }
        return str1.toString().trim();
    }
}