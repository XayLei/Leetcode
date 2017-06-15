/*
描述
作为H国的精英特工，你接到了一项任务，驾驶一辆吉普穿越布满监测雷达的禁区。
为了简化题目，我们可以把禁区想象为一个左下角是(0, 0)右上角是( W, H )的长方形区域。
区域中一共有 N 座雷达，其中第 i 座的坐标是(Xi, Yi )，监测范围是半径为 Ri 的圆形区域。
所有在圆内和圆上的运载工具都会被监测到。
你的目标是从左到右穿越禁区。你可以选择线段(0, 0)-(0, H)上任意一点作为起点，
线段(W, 0)-(W, H)上任意一点作为终点。在禁区内你可以沿任意路线行驶，只要保持始终在禁区内并且没有被雷达监测到。

给出禁区内的雷达部署方案，你需要判断是否存在满足条件的行驶路线。

输入
输入包含多组数据。

第1行是一个整数 T，表示以下有 T 组数据 (1 ≤ T ≤ 10)。

每组数据的第1行：三个整数 W, H, N (0 ≤ W, H ≤ 1000000, 1 ≤ N ≤ 1000)。

每组数据的第2-N+1行：每行三个整数Xi, Yi, Ri (0 ≤ Xi ≤ W, 0 ≤ Yi ≤ H, 1 ≤ Ri ≤ 1000000)。

输出
对于每组数据输出"YES"或者"NO"表示是否有满足条件的行驶路线。

样例输入
2
10 4 2
5 1 1
5 3 1
10 4 2
5 1 1
6 3 1

样例输出
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
			} // 创建并初始化一个数组，[0,1,2,3,...,N-1],类似于一个雷达数组

			for (int i = 0; i < N; i++) { // 取出第一个雷达
				int x1 = raders[i][0], y1 = raders[i][1], r1 = raders[i][2];
				for (int j = i + 1; j < N; j++) { // 取出下一个雷达
					int x2 = raders[j][0], y2 = raders[j][1], r2 = raders[j][2];
					double dis = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // 两个雷达区域中的圆心
					if (dis <= r1 + r2) { // 如果圆心距小于等于两个圆的半径和，说明两个雷达区域相交或相切
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