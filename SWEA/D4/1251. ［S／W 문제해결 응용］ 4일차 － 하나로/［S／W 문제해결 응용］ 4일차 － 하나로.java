import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			Map<Integer, int[]> islands = new HashMap<>();
			for (int i = 1; i <= N; i++) { // x좌표
				int[] island = new int[2];
				island[0] = sc.nextInt();
				islands.put(i, island);
			}
			for (int i = 1; i <= N; i++) { // y좌표
				islands.get(i)[1] = sc.nextInt();
			}
			double[][] edges = new double[N * (N - 1) / 2][3];
			int idx = 0;
			double E = sc.nextDouble();
			for (int i = 1; i <= N; i++) { // 환경 부담금을 포함한 간선 배열 생성
				for (int j = i + 1; j <= N; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					double dist = // 거리^2
							Math.pow(islands.get(i)[0] - islands.get(j)[0], 2)
									+ Math.pow(islands.get(i)[1] - islands.get(j)[1], 2);
					edges[idx][2] = E * dist;
					idx++;
				}
			}
			Arrays.sort(edges, new Comparator<double[]>() { // 정렬
				@Override
				public int compare(double[] o1, double[] o2) { // double로는 왜 아놛ㅎㄷ내ㅗ
					if (o1[2] < o2[2]) return -1;
					else if(o1[2] > o2[2]) return 1;
					else return 0;
				}
			});
			// 크루스칼
			double ans = 0;
			int pick = 0;
			p = new int[N + 1];
			for (int i = 1; i <= N; i++) { // make-set
				p[i] = i;
			}
			for (int i = 0; i < edges.length; i++) {
				double island1 = edges[i][0];
				double island2 = edges[i][1];
				if (findSet((int) island1) != findSet((int) island2)) { // cycle 아님
					union((int) island1, (int) island2);
					ans += edges[i][2];
					pick++;
				}
				if (pick == N - 1) break;
			}
			System.out.println("#" + tc + " " + Math.round(ans)); // 소수 첫째 자리에서 반올림
		}
	}
	
	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}