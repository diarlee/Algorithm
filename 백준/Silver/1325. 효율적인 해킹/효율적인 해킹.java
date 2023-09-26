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
	static int N;
	static int M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int C1 = Integer.parseInt(st.nextToken());
			int C2 = Integer.parseInt(st.nextToken());
			adjList[C1].add(C2);
		}
		output = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			if (adjList[i].size() != 0) bfs(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (output[i] > max) max = output[i];
		}
		for (int i = 1; i <= N; i++) {
			if (output[i] == max) System.out.print(i + " ");
		}
	}
	
	static void bfs(int C) {
		visited[C] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(C);
		while (!queue.isEmpty()) {
			int curC = queue.poll();
			for (int i : adjList[curC]) {
				if (!visited[i]) {
					visited[i] = true;
					output[i]++;
					queue.add(i);
				}
			}
		}
	}
}