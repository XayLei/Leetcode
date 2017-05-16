public class Solution {
    public String addBinary(String a, String b) {
        // int n = a.length() < b.length() ? a.length : b.length;
        // List<Character> list = new LinkedList<>();
        // for(int i = n-1; i >= 0; i--){
        //     char c1 = a.charAt(i);
        //     char c2 = b.charAt(i);
        //     char c3 = '0';
        //     if((c1=='1' && c2=='0') || (c1=='0' && c2=='1') && c3=='0'){
        //         list.addFirst('1');
        //     }
        //     if(c1=='0' && c2=='0' && c3=='0'){
        //         list.addFirst('0');
        //     }
        //     if(c1=='0' && c2=='0' && c3=='1'){
        //         list.addFirst('1');
        //         c3 = '0';
        //     }
        //     if(c1=='1' && c2=='1' && c3=='0'){
        //         list.addFirst('0');
        //         c3 = '1';
        //     }
        //     if(c1=='1' && c2=='1' && c3=='1'){
        //         list.addFirst('1');
        //     }
        // }
		/*
		二进制加法
		上面注释里的是自己的想法，没写完，感觉太蠢了
		下面是大家赞的比较多的思路
		*/
        StringBuilder s = new StringBuilder();
        int i=a.length()-1, j=b.length()-1;  //先是取出两个字符串的长度
        int carry =0 ;  //用于保存进位
        while(i>=0 || j>=0){  //这样处理就不用管两个字符串哪个长或是哪个短了
            int sum = carry;
            if(i>=0) sum += a.charAt(i--)-'0';
            if(j>=0) sum += b.charAt(j--)-'0';
            s.append(sum%2);  //这里sum可能是3啊，carry=1时，这不就是5了吗？？？？？？？
            carry = sum/2;
        }
        if(carry>0)  s.append(carry);   //都加完以后，如果进位不为0，则直接添加进位
        return s.reverse().toString();  //由于是从左往右添加的，所以最后的结果要反转一下
    }
}