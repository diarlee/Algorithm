import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int V;
	static int E;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] levels;
	static String ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= K; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				adjList[n1].add(n2);
				adjList[n2].add(n1);
			}
			visited = new boolean[V + 1];
			levels = new int[V + 1];
			ans = "YES";
			for (int i = 1; i <= V; i++) {
				if (!visited[i]) {
					bfs(i);
					if (ans.equals("No")) break;
				}
			}
			System.out.println(ans);
		}
	}
	
	static void bfs(int N) {
		visited[N] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N); // 0 레벨
		outter : while (!queue.isEmpty()) {
			int curN = queue.poll();
			for (int i : adjList[curN]) {
				if (visited[i]) {
					if (levels[i] == levels[curN]) {
						ans = "NO";
						break outter;
					}
				}
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					levels[i] = levels[curN] + 1;
				}
			}
		}
	}
}