public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) { //如果分子为0，则返回字符串0
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : ""); // 判断分子分母是否有负数，如果都为正数或负数，则不添加负号。
        long num = Math.abs((long)numerator);  //转为绝对值
        long den = Math.abs((long)denominator);  //转为绝对值
        
        // integral part
        res.append(num / den); //添加结果的整数部分
        num %= den; //将num赋值为余数，这里有问题，当输入2/3时，这里num还是2，没有变为66666.....，难道是因为无限循环超过了long的大小，所以不变
        if (num == 0) {  //如果余数为0，则直接返回结果，结束程序
            return res.toString();
        }
        
        // fractional part
        res.append("."); //余数不为0，则开始处理小数部分，先添加小数点
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {  //这里处理重复的方法看不太懂
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {  //如果出现重复，就加括号
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }else {
                map.put(num, res.length()); //没出现重复且num不为0，更新num和对应的字符串长度
            }
        }
        return res.toString();
    }
}