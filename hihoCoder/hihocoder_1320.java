/*
描述
小Hi希望压缩一个只包含大写字母'A'-'Z'的字符串。他使用的方法是：如果某个子串 S 连续出现了 X 次，就用'X(S)'来表示。例如AAAAAAAAAABABABCCD可以用10(A)2(BA)B2(C)D表示。

此外，这种压缩方法是可以嵌套的，例如HIHOHIHOCODERHIHOHIHOCODER可以表示成2(2(HIHO)CODER)。

对于一个字符串 S ，合法的压缩表示可能有很多种。例如AAAAAAAAAABABABCCD还可以表示成9(A)3(AB)CCD。小Hi希望知道其中最短的表示方法长度是多少。

输入
第一行一个正整数 T (1 ≤ T ≤ 10)，表示测试数据的组数。

以下 T 行每行一个字符串 S ，长度不超过100。

输出
对于每组数据，输出最短的表示方法的长度。
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