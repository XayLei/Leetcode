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
		�����Ƽӷ�
		����ע��������Լ����뷨��ûд�꣬�о�̫����
		�����Ǵ���޵ıȽ϶��˼·
		*/
        StringBuilder s = new StringBuilder();
        int i=a.length()-1, j=b.length()-1;  //����ȡ�������ַ����ĳ���
        int carry =0 ;  //���ڱ����λ
        while(i>=0 || j>=0){  //��������Ͳ��ù������ַ����ĸ��������ĸ�����
            int sum = carry;
            if(i>=0) sum += a.charAt(i--)-'0';
            if(j>=0) sum += b.charAt(j--)-'0';
            s.append(sum%2);  //����sum������3����carry=1ʱ���ⲻ����5���𣿣�����������
            carry = sum/2;
        }
        if(carry>0)  s.append(carry);   //�������Ժ������λ��Ϊ0����ֱ����ӽ�λ
        return s.reverse().toString();  //�����Ǵ���������ӵģ��������Ľ��Ҫ��תһ��
    }
}