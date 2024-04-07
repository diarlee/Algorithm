import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] times;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		times = new int[200001];
		Arrays.fill(times, 100000);
		bfs();
		System.out.println(times[K]);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		times[N] = 0;
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			if (pos == K) return;
			if (pos < 0 || pos > 100000) continue;
			if (times[pos + 1] > times[pos] + 1) {
				queue.add(pos + 1);
				times[pos + 1] = times[pos] + 1;
			}
			if (times[pos * 2] > times[pos] + 1) {
				queue.add(pos * 2);
				times[pos * 2] = times[pos] + 1;
			}
			if (pos != 0 && times[pos - 1] > times[pos] + 1) {
				queue.add(pos - 1);
				times[pos - 1] = times[pos] + 1;
			}
		}
	}
}