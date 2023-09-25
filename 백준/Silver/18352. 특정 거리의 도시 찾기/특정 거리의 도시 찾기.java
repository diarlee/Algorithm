import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int X;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());
			adjList[N1].add(N2);
		}
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		bfs(X);
		boolean ans = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				ans = true;
			}
		}
		if (!ans) System.out.println(-1);
	}
	
	static void bfs(int V) {
		visited[V] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		while (!queue.isEmpty()) {
			int curV = queue.poll();
			if (dist[curV] > K) break;
			for (int i : adjList[curV]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					dist[i] = dist[curV] + 1;
				}
			}
		}
	}
}