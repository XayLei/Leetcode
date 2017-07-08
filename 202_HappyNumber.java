public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int remain, squareNum;
        while(inLoop.add(n)){ //判断循环过程中是否出现重复数字，如果重复，则直接返回false
            squareNum = 0;
            while(n>0){ //计算n的每位数的平方和
                remain = n%10;
                squareNum += remain * remain;
                n = n/10;
            }
            if(squareNum == 1){
                return true;
            }
            n = squareNum;
        }
        return false;
    }
}