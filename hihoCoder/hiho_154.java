/*
����
��ΪH���ľ�Ӣ�ع�����ӵ���һ�����񣬼�ʻһ�����մ�Խ��������״�Ľ�����
Ϊ�˼���Ŀ�����ǿ��԰ѽ�������Ϊһ�����½���(0, 0)���Ͻ���( W, H )�ĳ���������
������һ���� N ���״���е� i ����������(Xi, Yi )����ⷶΧ�ǰ뾶Ϊ Ri ��Բ������
������Բ�ں�Բ�ϵ����ع��߶��ᱻ��⵽��
���Ŀ���Ǵ����Ҵ�Խ�����������ѡ���߶�(0, 0)-(0, H)������һ����Ϊ��㣬
�߶�(W, 0)-(W, H)������һ����Ϊ�յ㡣�ڽ����������������·����ʻ��ֻҪ����ʼ���ڽ����ڲ���û�б��״��⵽��

���������ڵ��״ﲿ�𷽰�������Ҫ�ж��Ƿ����������������ʻ·�ߡ�

����
��������������ݡ�

��1����һ������ T����ʾ������ T ������ (1 �� T �� 10)��

ÿ�����ݵĵ�1�У��������� W, H, N (0 �� W, H �� 1000000, 1 �� N �� 1000)��

ÿ�����ݵĵ�2-N+1�У�ÿ����������Xi, Yi, Ri (0 �� Xi �� W, 0 �� Yi �� H, 1 �� Ri �� 1000000)��

���
����ÿ���������"YES"����"NO"��ʾ�Ƿ���������������ʻ·�ߡ�

��������
2
10 4 2
5 1 1
5 3 1
10 4 2
5 1 1
6 3 1

�������
NO
YES
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, W, H, N;
		T = sc.nextInt();
		while (T-- > 0) {
			W = sc.nextInt();
			H = sc.nextInt();
			N = sc.nextInt();
			int[][] raders = new int[N][3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					raders[i][j] = sc.nextInt();
				}
			}
			// TODO
			int ans = 1;
			// TODO
			int[] hash = new int[N];
			for (int i = 0; i < N; i++) {
				hash[i] = i;
			} // ��������ʼ��һ�����飬[0,1,2,3,...,N-1],������һ���״�����

			for (int i = 0; i < N; i++) { // ȡ����һ���״�
				int x1 = raders[i][0], y1 = raders[i][1], r1 = raders[i][2];
				for (int j = i + 1; j < N; j++) { // ȡ����һ���״�
					int x2 = raders[j][0], y2 = raders[j][1], r2 = raders[j][2];
					double dis = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // �����״������е�Բ��
					if (dis <= r1 + r2) { // ���Բ�ľ�С�ڵ�������Բ�İ뾶�ͣ�˵�������״������ཻ������
						int part1 = hash[j], part2 = hash[i];
						while (hash[part1] != part1)
							part1 = hash[part1];
						while (hash[part2] != part2)
							part2 = hash[part2];
						hash[part1] = part2;
					}
				}
			}

			List<Integer> parent = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int par = hash[i];
				while (par != hash[par])
					par = hash[par];
				hash[i] = par;
				parent.add(par);
			}

			for (Integer val : parent) {
				int top = Integer.MIN_VALUE, bot = Integer.MAX_VALUE;
				for (int i = 0; i < N; i++) {
					if (hash[i] == val) {
						top = Math.max(top, raders[i][1] + raders[i][2]);
						bot = Math.min(bot, raders[i][1] - raders[i][2]);
						if (top >= H && bot <= 0) {
							ans = 0;
							i = N;
							break;
						}
					}
				}
				if(ans == 0) break;
			}
			if(ans==1){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}