import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] adjList;
	static int results[][];
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		results = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			bfs(i);
		}
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (int j = 1; j <= N; j++) {
				tmp += results[i][j];
			}
			if (tmp < min) {
				min = tmp;
				result = i;
			}
		}
		System.out.println(result);
	}
	
	static void bfs(int stNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(stNode);
		visited[stNode] = true;
		while (!queue.isEmpty()) {
			int curNode = queue.poll();
			for (int nextNode : adjList[curNode]) {
				if (!visited[nextNode]) {
					queue.add(nextNode);
					visited[nextNode] = true;
					results[stNode][nextNode] = results[stNode][curNode] + 1;
				}
			}
		}
	}
}