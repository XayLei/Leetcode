public class Solution {
    public boolean isUgly(int num) {
        // if(num<0) return false;
        // if(num==1) return true;
        // while(num>0){
        //     if(num%2==0){
        //         num = num/2;
        //         if(num==1)  return true;
        //     }else if(num%3==0){
        //         num=num/3;
        //         if(num==1)  return true;
        //     }else if(num%5==0){
        //         num=num/5;
        //         if(num==1)  return true;
        //     }
        // }
        // return false;
		/*
		上面注释的是自己写的，超时了，so sad！！！
		下面是一位外国牛人写的，真是好厉害啊！！
		*/
        if(num>0){
            for(int i : new int[]{2,3,5}){
                while(num%i==0){
                    num /= i;
                }
            }
        }
        return num==1;
    }
}