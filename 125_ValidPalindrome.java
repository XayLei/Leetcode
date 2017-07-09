public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return false;
        int left=0, right=s.length()-1;
        char cHead, cTail;
        while(left<=right){
            cHead = s.charAt(left);
            cTail = s.charAt(right);
            if(!Character.isLetterOrDigit(cHead)){
                left++;
            }else if(!Character.isLetterOrDigit(cTail)){
                right--;
            }else{
                if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}