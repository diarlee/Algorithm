import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});

		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		int pick = 0;
		int cost = 0;
		int idx = 0;
		while (pick != V - 1) {
			int v1 = edges[idx][0];
			int v2 = edges[idx][1];
			if (findSet(v1) != findSet(v2)) {
				union(v1, v2);
				cost += edges[idx][2];
				pick++;
			}
			idx++;
		}
		System.out.println(cost);
	}
	
	static int findSet(int x) {
		if (p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
		if (x > y) {
			p[findSet(x)] = findSet(y);
		} else {
			p[findSet(y)] = findSet(x);
		}
	}
}