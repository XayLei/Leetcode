public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i< 1<<n; i++)  result.add(i ^ i>>1);
        return result;
    }
}

/*
grayCode是一种特殊的二进制码，如：
                                 00 - 0
                                 01 - 1
                                 11 - 3
                                 10 - 2
			1<<n    这个就代表将二进制1向左移位
			      例如：当n=2时，1<<2就是100，这里100就是8，所以i的最大值要小于8，正好是两位二进制的最大值
				        当n=3时，1<<3就是1000，这里1000就是16
						
			i>>1    这个是将每个二进制i值向右移动1位
			      例如： 0 - 00  》》》  00   》》》A ^ B = 00 - 0
				         1 - 01  》》》  00   》》》A ^ B = 01 - 1
						 2 - 10  》》》  01   》》》A ^ B = 11 - 3
						 3 - 11  》》》  01   》》》A ^ B = 10 - 2
						      A           B
			^  这个符号的意思就是异或，相同位则为0，不同位则为1，具体如上
			
			最后的结果正好符合grayCode的要求
*/