public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int remain, squareNum;
        while(inLoop.add(n)){ //�ж�ѭ���������Ƿ�����ظ����֣�����ظ�����ֱ�ӷ���false
            squareNum = 0;
            while(n>0){ //����n��ÿλ����ƽ����
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