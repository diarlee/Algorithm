import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<int[]>[] adjList;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[p].add(new int[] {c, w});
			adjList[c].add(new int[] {p, w});
		}
		
		max = 0;
		for (int i = 1; i <= n; i++) {
			if (adjList[i].size() == 1) {
				visited = new boolean[n + 1];
				dfs(i, 0);
			}
				
		}
		System.out.println(max);
	}

	static void dfs(int curNode, int d) {
		visited[curNode] = true;
//		System.out.println(curNode);
		if (d > max) max = d;
		for (int[] node : adjList[curNode]) {
			int v = node[0];
			int w = node[1];
			if (!visited[v]) {
				dfs(v, w + d);
			}
		}
	}
}