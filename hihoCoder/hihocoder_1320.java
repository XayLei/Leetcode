/*
����
СHiϣ��ѹ��һ��ֻ������д��ĸ'A'-'Z'���ַ�������ʹ�õķ����ǣ����ĳ���Ӵ� S ���������� X �Σ�����'X(S)'����ʾ������AAAAAAAAAABABABCCD������10(A)2(BA)B2(C)D��ʾ��

���⣬����ѹ�������ǿ���Ƕ�׵ģ�����HIHOHIHOCODERHIHOHIHOCODER���Ա�ʾ��2(2(HIHO)CODER)��

����һ���ַ��� S ���Ϸ���ѹ����ʾ�����кܶ��֡�����AAAAAAAAAABABABCCD�����Ա�ʾ��9(A)3(AB)CCD��СHiϣ��֪��������̵ı�ʾ���������Ƕ��١�

����
��һ��һ�������� T (1 �� T �� 10)����ʾ�������ݵ�������

���� T ��ÿ��һ���ַ��� S �����Ȳ�����100��

���
����ÿ�����ݣ������̵ı�ʾ�����ĳ��ȡ�
*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			System.out.println(solve(s));
		}
	}

	private static int solve(String s) {
		int length = s.length();
		int[][] dp = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				dp[i][j] = length;
			}
		}
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		for (int len = 2; len <= length; len++) {
			for (int i = 0; i + len <= length; i++) {
				int j = i + len - 1;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
				}
				for (int k = 1; k <= len; k++) {
					if (len % k == 0 && s.substring(i, i + k).equals(s.substring(j - k + 1, j + 1))
							&& s.substring(i, j - k + 1).equals(s.substring(i + k, j + 1))) {
						dp[i][j] = Math.min(dp[i][j], dp[i][i + k - 1] + 2 + Integer.toString(len / k).length());
					}
				}
			}
		}
		return dp[0][length - 1];
	}
}