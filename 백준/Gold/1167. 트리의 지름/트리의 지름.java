import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]>[] adjList;
	static boolean[] visited;
	static int[] max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int vv = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			while (true) {
				adjList[v].add(new int[] {vv, dis});
				vv = Integer.parseInt(st.nextToken());
				if (vv == -1) break;
				dis = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[V + 1];
		max = new int[2];
		dfs(1, 0);
		int node = max[1];
		max = new int[2];
		dfs(node, 0);
		System.out.println(max[0]);
	}
	
	static void dfs(int curNode, int d) {
		visited[curNode] = true;
		if (max[0] < d) {
			max[0] = d;
			max[1] = curNode;
		}
		for (int[] node : adjList[curNode]) {
			int v = node[0];
			int w = node[1];
			if (!visited[v]) dfs(v, d + w);
		}
		visited[curNode] = false;
	}
}