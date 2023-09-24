import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		visited = new boolean[N];
		ans = 0;
		// 5개의 노드가 연속적으로 연결되는 경우 찾기
		// 시작 노드에 따라 결과가 달라짐
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
			if (ans == 1) break;
		}
		System.out.println(ans);
	}
	
	static void dfs(int v, int cnt) {
		visited[v] = true;
		if (ans == 1) return; // 결과가 나왔을때 남은 재귀들을 빠르게 종료시킴
		if (cnt == 4) {
			ans = 1;
			return;
		}
		for (int i : adjList[v]) {
			if (!visited[i]) dfs(i, cnt + 1);
		}
		visited[v] = false;
	}
}