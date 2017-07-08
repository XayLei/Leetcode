public class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int addResult,temp;
        while(num >= 10){
            addResult = 0;
            while(num>0){
                addResult += num%10;
                num = num/10;
            }
            num = addResult;
        }
        return num;
    }
}