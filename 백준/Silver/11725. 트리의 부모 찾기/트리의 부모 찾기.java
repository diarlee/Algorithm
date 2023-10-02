import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());
			adjList[N1].add(N2);
			adjList[N2].add(N1);
		}
		parents = new int[N + 1];
		dfs(1);
		for (int i = 2; i <= N; i++)
			System.out.println(parents[i]);
	}
	
	static void dfs(int node) {
		visited[node] = true;
		for (int i : adjList[node]) {
			if (!visited[i]) {
				parents[i] = node;
				dfs(i);
			}
		}
	}
}