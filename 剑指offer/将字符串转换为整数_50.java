public class Solution {
    public int StrToInt(String str) {
        if(str.length()==0) return 0;
        boolean negative = false;
        if(str.charAt(0)=='-'){
            str = str.substring(1);
            negative = true;
        }else if(str.charAt(0)=='+'){
            str = str.substring(1);
        }
        char[] c = str.toCharArray();
        int result = 0;
        for(int i=0;i<c.length;i++){
            if(c[i] < '0' || c[i] > '9'){
                result = 0;
                break;
            }
            result = result * 10 + Character.digit(c[i],10);
        }
        if(negative) result = -result;
        return result;
    }
}