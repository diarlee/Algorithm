import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] cnts;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnts = new int[200001];
		visited = new int[200001];
		Arrays.fill(visited, 100000);
		bfs(N);
		System.out.println(visited[K]);
		System.out.println(cnts[K]);
	}
	
	static void bfs(int start) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {start, 0});
		visited[start] = 0;
		cnts[start]++;
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean getResult = false;
			for (int i = 0; i < size; i++) {
				Integer[] node = queue.poll();
				int pos = node[0];
				int time = node[1];
				if (pos == K) {
					getResult = true;
				}
				if (0 <= pos - 1 && time + 1 <= visited[pos - 1]) {
					cnts[pos - 1] += cnts[pos];
					if (time + 1 < visited[pos - 1]) {
						queue.add(new Integer[] {pos - 1, time + 1});
						visited[pos - 1] = time + 1;
					}
				}
				if (pos + 1 <= 200000 && time + 1 <= visited[pos + 1]) {
					cnts[pos + 1] += cnts[pos];
					if (time + 1 < visited[pos + 1]) {
						queue.add(new Integer[] {pos + 1, time + 1});
						visited[pos + 1] = time + 1;
					}
				}
				if (pos != 0 && pos <= 100000 && time + 1 <= visited[pos * 2]) {
					cnts[pos * 2] += cnts[pos];
					if (time + 1 < visited[pos * 2]) {
						queue.add(new Integer[] {pos * 2, time + 1});
						visited[pos * 2] = time + 1;
					}
				}
			}
			if (getResult) return;
		}
	}
}