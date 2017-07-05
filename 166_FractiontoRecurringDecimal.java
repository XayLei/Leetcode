public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) { //�������Ϊ0���򷵻��ַ���0
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : ""); // �жϷ��ӷ�ĸ�Ƿ��и����������Ϊ��������������Ӹ��š�
        long num = Math.abs((long)numerator);  //תΪ����ֵ
        long den = Math.abs((long)denominator);  //תΪ����ֵ
        
        // integral part
        res.append(num / den); //��ӽ������������
        num %= den; //��num��ֵΪ���������������⣬������2/3ʱ������num����2��û�б�Ϊ66666.....���ѵ�����Ϊ����ѭ��������long�Ĵ�С�����Բ���
        if (num == 0) {  //�������Ϊ0����ֱ�ӷ��ؽ������������
            return res.toString();
        }
        
        // fractional part
        res.append("."); //������Ϊ0����ʼ����С�����֣������С����
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {  //���ﴦ���ظ��ķ�������̫��
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {  //��������ظ����ͼ�����
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }else {
                map.put(num, res.length()); //û�����ظ���num��Ϊ0������num�Ͷ�Ӧ���ַ�������
            }
        }
        return res.toString();
    }
}